package cn.bugstack.springframework.beans.factory.beancreate;

import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.BeanDefinition;
import cn.bugstack.springframework.beans.factory.beanregistry.impl.DefaultSingletonBeanRegistry;
import cn.bugstack.springframework.beans.factory.BeanFactory;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * <p>
 * BeanDefinition注册表接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    // 接口实现：根据名称获取Bean实例的方法
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    // 接口实现：根据名称和参数获取Bean实例的方法
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    // 接口实现：根据名称和类型获取Bean实例的方法
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    // 根据名称和参数获取Bean实例的实现方法
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 首先尝试从单例缓存中获取Bean实例，如果存在则直接返回
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        // 如果缓存中不存在，则获取对应的BeanDefinition对象
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    // 抽象方法，由子类实现，用于获取指定名称的Bean的定义信息
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 抽象方法, 由子类实现，用于根据Bean的定义信息创建Bean实例
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

}
