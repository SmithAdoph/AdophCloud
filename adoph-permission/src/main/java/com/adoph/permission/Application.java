package com.adoph.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * web启动配置
 *
 * @author Adoph
 * @version v1.0
 * @date 2017/8/11
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.adoph.permission.dao.sys")
@ComponentScan(basePackages = {"com.adoph"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
