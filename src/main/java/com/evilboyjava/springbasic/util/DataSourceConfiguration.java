package com.evilboyjava.springbasic.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 14-2-9.
 */
@Configuration
@ComponentScan
public class DataSourceConfiguration {
    @Bean
    public BasicDataSource basicDataSource() {
        Properties dbProps = new Properties();
        try {
            dbProps.load(Object.class.getResourceAsStream("/mysqldatabase.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicDataSource mysqlDataSource = new BasicDataSource();
        mysqlDataSource.setDriverClassName(dbProps.getProperty("jdbc.driverClassName"));
        mysqlDataSource.setUrl(dbProps.getProperty("jdbc.url"));
        mysqlDataSource.setUsername(dbProps.getProperty("jdbc.username"));
        mysqlDataSource.setPassword(dbProps.getProperty("jdbc.password"));
        mysqlDataSource.setInitialSize(2);
        mysqlDataSource.setMaxActive(5);
        mysqlDataSource.setMaxIdle(2);
        mysqlDataSource.setMinIdle(1);
        return mysqlDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(basicDataSource());
        return transactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate =  new JdbcTemplate(basicDataSource());
        return jdbcTemplate;
    }

}
