package cn.bugstack.springframework.beans.factory.beaninstantiation.impl;

import cn.bugstack.springframework.beans.factory.beaninstantiation.InstantiationStrategy;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description 基于CGLIB的策略适用于需要创建代理类的场景，例如代理类的方法增强等
 */

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        // 创建Enhancer对象，用于生成子类
        Enhancer enhancer = new Enhancer();

        // 设置父类，即要被代理的类
        enhancer.setSuperclass(beanDefinition.getBeanClass());

        // 设置回调对象，使用一个空回调NoOp,主要用于防止CGLIB创建的代理类无限循环地使用hashCode方法
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        // 通过Enhancer创建一个没有构造函数的代理类实例
        if (null == ctor) return enhancer.create();

        // 通过Enhancer根据指定的构造函数和参数创建代理类实例
        return enhancer.create(ctor.getParameterTypes(), args);
    }

}
