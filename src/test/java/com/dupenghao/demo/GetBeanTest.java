package com.dupenghao.demo;

import com.dupenghao.mybatis.constant.ApplicationInstance;
import com.dupenghao.mybatis.util.Util;
import org.junit.Test;

/**
 * Created by 杜鹏豪 on 2022/8/22.
 */
public class GetBeanTest {

    @Test
    public void testGetBean(){
        ApplicationInstance instance = Util.getBean(ApplicationInstance.class);

    }

}
