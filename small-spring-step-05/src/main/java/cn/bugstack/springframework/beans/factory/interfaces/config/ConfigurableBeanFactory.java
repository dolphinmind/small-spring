package cn.bugstack.springframework.beans.factory.interfaces.config;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.beanregistry.SingletonBeanRegistry;
import cn.bugstack.springframework.beans.factory.interfaces.HierarchicalBeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 *
 * @description 提供一种可配置的BeanFactory接口，用于管理Bean的层次结构以及注册和获取单例Bean
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    // 表示单例作用域，在Spring容器中，单例作用域的Bean在容器中只存在一个实例
    String SCOPE_SINGLETON = "singleton";

    //  表示原型作用域，在Spring容器中，原型作用域的Bean每次获取都会创建一个新的实例
    String SCOPE_PROTOTYPE = "prototype";

}
