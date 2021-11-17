//package com.libra.spring.demo.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * 第二个数据源配置
// *
// */
//@Configuration
//public class SecondDataSourceConfig {
//
//    @Bean(name = "backup-dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.backup")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "backup-sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("backup-dataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "backup-transactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("backup-dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "backup-sqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("backup-sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}