package com.ph.springbootcondition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConditionApplication {

    public static void main(String[] args) {
        //启动springboot的应用，返回spring的ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootConditionApplication.class, args);
        //获取bean，redisTemplate
        // Object redisTemplate = context.getBean("redisTemplate");
        // System.out.println(redisTemplate);

        Object user = context.getBean("user");
        System.out.println(user);
    }

}
