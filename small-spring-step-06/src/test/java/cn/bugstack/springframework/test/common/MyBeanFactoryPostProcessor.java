package cn.bugstack.springframework.test.common;

import cn.bugstack.springframework.beans.factory.support.exception.BeansException;
import cn.bugstack.springframework.beans.factory.config.beandefinition.PropertyValue;
import cn.bugstack.springframework.beans.factory.config.beandefinition.PropertyValues;
import cn.bugstack.springframework.beans.factory.support.beanfactory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.beanpostprocessor.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
