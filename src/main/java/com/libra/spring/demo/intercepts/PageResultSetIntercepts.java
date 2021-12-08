//package com.libra.spring.demo.intercepts;
//
//
//import com.libra.spring.demo.model.bo.PageInfo;
//import com.libra.spring.demo.thread.PageHelper;
//
//import org.apache.ibatis.cache.CacheKey;
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.executor.resultset.ResultSetHandler;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.ParameterMapping;
//import org.apache.ibatis.mapping.SqlSource;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//import org.apache.tomcat.util.buf.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Locale;
//import java.util.Properties;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * @description: 测试拦截器
// * @author: sx
// * @date: 2021-10:51 上午-2021/11/23
// */
//@Component
//@Intercepts({
//        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
//})
//public class PageResultSetIntercepts implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        ResultSetHandler target = (ResultSetHandler)invocation.getTarget();
//        Object[] args = invocation.getArgs();
//        Statement statement = (Statement)args[0];
//        List<Object> objects = target.handleResultSets(statement);
//
//        return invocation.proceed();
//    }
//
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        System.out.println("setProperties");
//    }
//}
