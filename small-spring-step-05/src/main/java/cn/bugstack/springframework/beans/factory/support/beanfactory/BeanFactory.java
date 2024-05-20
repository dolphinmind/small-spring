package cn.bugstack.springframework.beans.factory.support.beanfactory;

import cn.bugstack.springframework.beans.factory.config.BeansException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanFactory {
    // 根据Bean的名称从容器中获取对应的Bean对象
    Object getBean(String name) throws BeansException;

    // 根据Bean的名称和参数从容器中获取对应的Bean对象，该方法允许传入参数，以便在获取Bean实例时进行参数注入
    Object getBean(String name, Object... args) throws BeansException;

    // 根据Bean的名称和类型从容器中获取对应的Bean对象，该方法不仅要求传入Bean的名称，还要求传入要获取的Bean的类型，以便在获取Bean实例后进行类型转换
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
