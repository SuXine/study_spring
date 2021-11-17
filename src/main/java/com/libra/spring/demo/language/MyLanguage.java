package com.libra.spring.demo.language;


import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.defaults.RawLanguageDriver;
import org.apache.ibatis.session.Configuration;

/**
 * @description: Language demo
 * @author: sx
 * @date: 2021-11:42 上午-2021/11/17
 */
public class MyLanguage extends RawLanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, XNode script, Class<?> parameterType) {
        SqlSource source = super.createSqlSource(configuration, script, parameterType);
        print();
        return source;
    }

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        SqlSource source = super.createSqlSource(configuration, script, parameterType);
        print();
        return source;
    }

    private void print(){
        System.out.println("使用自定义的语言驱动");
    }
}
