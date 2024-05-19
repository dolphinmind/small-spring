package cn.bugstack.springframework.beans.factory.support.instantiationstrategy;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.bean.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * <p>
 * Bean 实例化策略
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
