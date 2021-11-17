//package com.libra.spring.demo.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * 主数据源配置
// *
// * @date 2020/12/19
// */
//@Configuration
//public class MainDataSourceConfig {
//
//    @Primary
//    @Bean(name = "main-dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.main")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "main-sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("main-dataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Primary
//    @Bean(name = "main-transactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("main-dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Primary
//    @Bean(name = "main-sqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("main-sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}