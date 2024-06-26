package cn.bugstack.springframework.beans.factory.interfaces.config;

import cn.bugstack.springframework.beans.factory.beanprocessor.BeanPostProcessor;
import cn.bugstack.springframework.beans.factory.interfaces.HierarchicalBeanFactory;
import cn.bugstack.springframework.beans.factory.beanregistry.SingletonBeanRegistry;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 * interface.
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);


}
