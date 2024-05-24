package cn.bugstack.springframework.beans.factory.beancreate;

import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.BeanDefinition;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 继承实现
 *              1. 自动创建Bean对象
 *              2. 将Bean实例对象装配到单例对象集中
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

}
