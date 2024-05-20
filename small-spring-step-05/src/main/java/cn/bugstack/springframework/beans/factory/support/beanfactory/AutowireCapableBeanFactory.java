package cn.bugstack.springframework.beans.factory.support.beanfactory;

/**
 * Extension of the {@link BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * @description 表可自动装配的Bean工厂，包括自动装配属性、构造函数等，使得Spring容器能够更加智能地管理和组装Bean实例
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

}
