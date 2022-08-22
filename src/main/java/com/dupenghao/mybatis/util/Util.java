package com.dupenghao.mybatis.util;

import com.dupenghao.mybatis.constant.ApplicationInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 杜鹏豪 on 2022/8/22.
 */
public class Util {

    @Autowired
    private ApplicationInstance instance;

    public  static <T> T getBean(Class<T> clazz){
        System.out.println(clazz);
        try {
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                if(constructor.getParameterCount()==0){
                    constructor.setAccessible(true);
                    try {
                    return  (T)constructor.newInstance();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
