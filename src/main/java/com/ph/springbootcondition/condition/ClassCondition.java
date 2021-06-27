package com.ph.springbootcondition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
// import redis.clients.jedis.Jedis;

/**
 * @program: springboot-condition
 * @description:
 * @author: panhao
 * @date: 2021-06-27 20:05
 **/
public class ClassCondition implements Condition {
    /*** 
     * @description:  conditionContext:上下文对象。用于获取环境，IOC容器，ClassLoader对象
     * annotatedTypeMetadata:注解的源对象。可以用于获取注解定义的属性值
     
     * @return: boolean
     * @author: panhao
     * @date: 
     */ 
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        Environment environment = conditionContext.getEnvironment();


        //1.需求：导入Jedis坐标后创建Bean
        //思路：判断redis.clients.jedis.Jedis文件是否存在
        // try {
        //     Class<?> aClass = Class.forName("redis.clients.jedis.Jedis");
        //     return true;
        // } catch (ClassNotFoundException e) {
        //     return false;
        // }

        //2.需求：导入通过注解属性值value指定坐标后创建bean
        //获取注解属性值value
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        // System.out.println(map);
        String[] value = (String[]) map.get("values");

        try {
            for (Object classname : value) {
                System.out.println(classname);
                Class<?> aClass = Class.forName((String) classname);
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }



    }
}
