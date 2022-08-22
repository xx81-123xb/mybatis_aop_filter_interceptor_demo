package com.dupenghao.mybatis.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by 杜鹏豪 on 2022/8/22.
 */
@Data
@Component("app")
public class ApplicationInstance {

    private ApplicationContext context;

    public ApplicationInstance(){
    }

    public ApplicationInstance(@Autowired ApplicationContext context){
        this.context=context;
    }

//    private ApplicationInstance(ApplicationContext context){
//        this.context=context;
//    }
//
//    private static class Inner{
//        private static ApplicationInstance INSTANCE=new ApplicationInstance();
//    }
//
//    public static ApplicationInstance getInstance(){
//        return Inner.INSTANCE;
//    }

}
