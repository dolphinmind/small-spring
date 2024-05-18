package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.bean.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.bean.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 继承实现，
 *              beanDefinitionMap装入的是BeanDefinition：容器+实体
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

}
