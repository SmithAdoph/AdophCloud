package com.adoph.test.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.adoph.test.jdbc")
public class SpringJdbcConfig {
    @Bean
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://eu.dbproxy.al.com:10000/vendorservice");
        dataSource.setUsername("app_vendorservice_rw");
        dataSource.setPassword("rpIT_23fSjWmSsQwx");
        return dataSource;
    }

    @Bean
    public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}