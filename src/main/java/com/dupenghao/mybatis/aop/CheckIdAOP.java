package com.dupenghao.mybatis.aop;

import com.dupenghao.mybatis.commans.AbstractPOJO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by 杜鹏豪 on 2022/8/18.
 */
@Configuration
@EnableAspectJAutoProxy
@Slf4j
@Component
@Aspect
public class CheckIdAOP {

    @Pointcut("execution(* com.dupenghao.mybatis.service.serviceimpl.*ServiceImpl.save(..))")
    public void checkIdPoint(){

    }

    @Before("checkIdPoint()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("args length:"+args.length);
        AbstractPOJO param = (AbstractPOJO) args[0];
        log.info("param:");
        if(param.getId()==null||param.getId().isEmpty()){
            String id = UUID.randomUUID().toString().replace("-","");
            param.setId(id);
            System.out.println("create id : "+id);
        }
    }


}
