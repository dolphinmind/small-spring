package cn.bugstack.springframework.test.common;

import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.PropertyValue;
import cn.bugstack.springframework.beans.bean.PropertyValues;
import cn.bugstack.springframework.beans.factory.interfaces.config.configlist.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.bean.BeanDefinition;
import cn.bugstack.springframework.beans.factory.beanprocessor.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
