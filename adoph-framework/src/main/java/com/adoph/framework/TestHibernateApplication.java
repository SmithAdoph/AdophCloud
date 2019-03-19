package com.adoph.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * web启动配置
 *
 * @author Adoph
 * @version v1.0
 * @date 2017/8/11
 */
@ServletComponentScan
@EntityScan( basePackages = {"com.adoph.test.pojo"} )
@ComponentScan(basePackages = {"com.adoph.test.hibernate", "com.adoph.test.spring"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class TestHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestHibernateApplication.class, args);
    }
}
