package com.adoph.framework.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * web启动配置
 *
 * @author Adoph
 * @version v1.0
 * @date 2017/8/11
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.adoph"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
