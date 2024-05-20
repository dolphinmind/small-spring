package cn.bugstack.springframework.beans.factory.support.beanfactory.impl;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanDefinitionRegistry;
import cn.bugstack.springframework.beans.factory.support.beanfactory.ConfigurableListableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    // 接口方法实现
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    // 接口方法实现
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    // 接口方法实现
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    // 接口方法实现
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    // 抽象方法实现
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

}
