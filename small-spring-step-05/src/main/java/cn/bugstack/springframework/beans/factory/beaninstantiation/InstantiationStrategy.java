package cn.bugstack.springframework.beans.factory.beaninstantiation;

import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 *
 * @description 描述一个实例化策略，用于根据给定的BeanDefinition、bean名称、构造函数和参数来实例化一个对象
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
