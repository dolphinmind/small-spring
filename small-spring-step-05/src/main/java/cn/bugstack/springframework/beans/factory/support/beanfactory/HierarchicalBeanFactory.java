package cn.bugstack.springframework.beans.factory.support.beanfactory;

/**
 * Sub-interface implemented by bean factories that can be part
 * of a hierarchy.
 * @description 继承自BeanFactory接口，定义了一些用于处理Bean层次结构的方法，比如获取父工厂、设置父工厂等
 */
public interface HierarchicalBeanFactory extends BeanFactory {

}
