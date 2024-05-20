package cn.bugstack.springframework.beans.factory.support.beanfactory;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.bean.BeanDefinition;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    /**
     * @description 根据给定的Bean名称，返回对应的BeanDefinition对象
     *              BeanDefinition描述了一个Bean的元数据信息，包括Bean的类、属性、构造函数等信息
     *              如果容器中不存在指定名称的Bean，则抛出BeansException异常
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
