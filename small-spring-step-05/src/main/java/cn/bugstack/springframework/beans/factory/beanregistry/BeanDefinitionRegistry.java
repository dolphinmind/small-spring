package cn.bugstack.springframework.beans.factory.beanregistry;

import cn.bugstack.springframework.beans.bean.BeanDefinition;
import cn.bugstack.springframework.exception.BeansException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description BeanDefinitionRegistry由BeanName 和beanDefinition组成构成键值对
 *
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册指定的BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
