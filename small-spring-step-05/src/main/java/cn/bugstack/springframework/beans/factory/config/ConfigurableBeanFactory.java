package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.support.beanfactory.HierarchicalBeanFactory;
import cn.bugstack.springframework.beans.factory.config.singleton.SingletonBeanRegistry;
import cn.bugstack.springframework.beans.factory.support.beanfactory.BeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
