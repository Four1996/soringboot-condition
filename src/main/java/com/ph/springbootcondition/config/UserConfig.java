package com.ph.springbootcondition.config;

import com.ph.springbootcondition.condition.ClassCondition;
import com.ph.springbootcondition.condition.ConditionOnClass;
import com.ph.springbootcondition.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-condition
 * @description:
 * @author: panhao
 * @date: 2021-06-27 20:04
 **/
@Configuration
public class UserConfig {
    @Bean
    // @Conditional(ClassCondition.class)
    @ConditionOnClass(values = "redis.clients.jedis.Jedis")
    public User user(){
        return new User();
    }
}
