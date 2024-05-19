package cn.bugstack.springframework.beans.factory.support.beanfactory;

import cn.bugstack.springframework.beans.factory.config.BeansException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
