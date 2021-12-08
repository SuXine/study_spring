package com.libra.spring.demo.intercepts;


import com.libra.spring.demo.model.bo.Page;
import com.libra.spring.demo.model.bo.PageInfo;
import com.libra.spring.demo.thread.PageHelper;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMap.Builder;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 测试拦截器
 * @author: sx
 * @date: 2021-10:51 上午-2021/11/23
 */
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class DemoIntercepts implements Interceptor {
    private static final Logger LOGGER       = LoggerFactory.getLogger(DemoIntercepts.class);
    public static final  String SQL_END_CHAR = ";";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        PageInfo pageInfo = PageHelper.getPageInfo();

        if (ObjectUtils.isEmpty(pageInfo)) {
            return invocation.proceed();
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("---- 分页插件执行 ---- : pageSize：{},pageNumber：{}", pageInfo.getPageSize(), pageInfo.getPageNumber());
        }

        Integer pageSize = pageInfo.getPageSize();
        Integer pageNumber = pageInfo.getPageNumber();

        String limitStr = " limit " + (pageNumber - 1) * pageSize + " , " + pageNumber * pageSize;

        Object[] args = invocation.getArgs();

        MappedStatement statementHandler = (MappedStatement) args[0];
        Object parameterObject = args[1];

        BoundSql boundSql = statementHandler.getBoundSql(parameterObject);

        String reg = "(?<=(select)).*?(?=(from))";

        String oldSql = boundSql.getSql();


        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(oldSql.toLowerCase(Locale.ROOT).replace("\n", " "));
        String countSql = "";
        if (matcher.find()) {
            countSql = matcher.replaceAll(" count(*) as __count__ ");
            if (!countSql.endsWith(SQL_END_CHAR)) {
                countSql = countSql + SQL_END_CHAR;
            }
        }


        String newSql = oldSql;
        if (newSql.contains(SQL_END_CHAR)) {
            String[] split = newSql.split(SQL_END_CHAR);
            if (split.length > 1) {
                throw new RuntimeException("使用分页数据执行SQL不能多语句查询");
            }
            newSql.replace(SQL_END_CHAR, limitStr);
        } else {
            newSql = newSql + limitStr;
        }

        if (!newSql.endsWith(SQL_END_CHAR)) {
            newSql = newSql + SQL_END_CHAR;
            newSql = newSql + "\n" + countSql;
        }

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        List<ParameterMapping> newParameterMappings = new ArrayList<>();
        newParameterMappings.addAll(parameterMappings);
        newParameterMappings.addAll(parameterMappings);
        BoundSql newBoundSql = new BoundSql(statementHandler.getConfiguration(), newSql,
                newParameterMappings, boundSql.getParameterObject());

        MappedStatement newMappedStatement = makeNewMappedStatement(statementHandler, newBoundSql);

        args[0] = newMappedStatement;

        PageHelper.clear();
        ArrayList<Object> proceed = (ArrayList<Object>) invocation.proceed();
        Page page = new Page() ;
        ArrayList data = (ArrayList) proceed.get(0);
        data.forEach(item -> {
            page.add(item);
        });
        page.setTotal((Long) ((ArrayList) proceed.get(1)).get(0));
        return page;
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties");
    }

    /**
     * 修改MappedStatement中的sql语句
     */
    private MappedStatement makeNewMappedStatement(MappedStatement statementHandler, BoundSql newBoundSql) {
        MappedStatement.Builder builder =
                new MappedStatement.Builder(statementHandler.getConfiguration(), statementHandler.getId(),
                        new SqlSource() {
                            @Override
                            public BoundSql getBoundSql(Object parameterObject) {
                                return newBoundSql;
                            }
                        }, statementHandler.getSqlCommandType());

        String[] resultSets = statementHandler.getResultSets();

        if (ObjectUtils.isEmpty(resultSets)) {
            resultSets = new String[2];
            resultSets[0] = "__date__";
            resultSets[1] = "__count__";
        } else {
            List<String> resultSet = Arrays.asList(resultSets);
            resultSet.add("__count__");
            resultSets = (String[]) resultSet.toArray();
        }

        List<ResultMap> resultMaps = statementHandler.getResultMaps();

        ResultMapping resultMapping = new ResultMapping.Builder(statementHandler.getConfiguration(), "__count__", "__count__", Long.class).resultSet("__count__").foreignColumn("__count__").build();
        ResultMap build = new Builder(statementHandler.getConfiguration(), "__count__", Long.class, Arrays.asList(resultMapping)).build();


        List<ResultMap> newResultMaps = new ArrayList<>();
        newResultMaps.addAll(resultMaps);
        newResultMaps.add(build);

        builder.cache(statementHandler.getCache())
               .databaseId(statementHandler.getDatabaseId())
               .fetchSize(statementHandler.getFetchSize())
               .flushCacheRequired(statementHandler.isFlushCacheRequired())
               .keyGenerator(statementHandler.getKeyGenerator())
               .lang(statementHandler.getLang())
               .parameterMap(statementHandler.getParameterMap())
               .resource(statementHandler.getResource())
               .resultMaps(newResultMaps)
               .resultOrdered(statementHandler.isResultOrdered())
               .resultSetType(statementHandler.getResultSetType())
               .statementType(statementHandler.getStatementType())
               .timeout(statementHandler.getTimeout())
               .useCache(statementHandler.isUseCache())
               .keyColumn(!ObjectUtils.isEmpty(statementHandler.getKeyColumns()) ? StringUtils.join(Arrays.asList(statementHandler.getKeyColumns()), ',') : null)
               .keyProperty(!ObjectUtils.isEmpty(statementHandler.getKeyProperties()) ? StringUtils.join(Arrays.asList(statementHandler.getKeyProperties()), ',') : null)
               .resultSets(StringUtils.join(Arrays.asList(resultSets), ','))

        ;
        MappedStatement newMappedStatement = builder.build();
        return newMappedStatement;
    }
}
