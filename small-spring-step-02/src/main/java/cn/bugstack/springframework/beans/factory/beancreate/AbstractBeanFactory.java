package cn.bugstack.springframework.beans.factory.beancreate;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.bean.BeanDefinition;
import cn.bugstack.springframework.beans.factory.beanregistry.impl.DefaultSingletonBeanRegistry;

/**
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 模板设计模式，目标是什么？设计步骤
 *              0. 类的extends和implements组合使用，Bean才是老大哥，Singleton是小弟，统一接口GetBean获取
 *              1. 查看某个类是否为单例
 *              2. 不是，则将类进行BeanDefinition封装
 *              3. 再将BeanDefinition放进
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
