package com.dolphinmind.github.test.beans.factory.beaninitialize;

import cn.bugstack.springframework.beans.factory.beaninitialize.impl.InitializingBeanImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @ClassName InitializingBeanImplTest
 * @Description
 * @Author dolphinmind
 * @Date 2024/5/24
 */

public class InitializingBeanImplTest {
    @Test
    public void ApiTest() {
        ApplicationContext context =  new ClassPathXmlApplicationContext("spring-config.xml");
        InitializingBeanImpl initializingBean = (InitializingBeanImpl) context.getBean("initializingBeanImpl", InitializingBeanImpl.class);
        System.out.println("-----------------------------------");
        System.out.println("Bean retrieved from context:" + initializingBean);
    }
}
