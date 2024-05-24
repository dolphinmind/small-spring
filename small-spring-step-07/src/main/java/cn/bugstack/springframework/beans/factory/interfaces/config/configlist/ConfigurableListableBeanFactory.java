package cn.bugstack.springframework.beans.factory.interfaces.config.configlist;

import cn.bugstack.springframework.beans.factory.interfaces.AutowireCapableBeanFactory;
import cn.bugstack.springframework.beans.factory.interfaces.ListableBeanFactory;
import cn.bugstack.springframework.beans.factory.interfaces.config.ConfigurableBeanFactory;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.BeanDefinition;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
