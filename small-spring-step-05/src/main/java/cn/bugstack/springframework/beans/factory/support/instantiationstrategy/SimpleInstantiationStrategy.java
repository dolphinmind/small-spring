package cn.bugstack.springframework.beans.factory.support.instantiationstrategy;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.bean.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 基于Java本身自带的方法DeclaredConstructor来创建含义构造函数的Bean对象
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                // 如果存在构造函数，则使用该构造函数并传入参数args来实例化对象
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 如果不存在构造函数，则使用默认的无参构造函数来实例化对象
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }

}
