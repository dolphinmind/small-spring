package cn.bugstack.springframework.beans.factory.support.beanfactory;

import cn.bugstack.springframework.beans.factory.config.BeansException;

import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 * <p>
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回该类型的所有Bean 实例
     * @param type
     * @param <T>
     * @return Map对象，键为Bean的名称，值是对应的Bean的实例
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * 返回注册表中所有的Bean名称，这些名称是在容器中定义的Bean的名称，用于标识和获取对应的Bean实例
     */
    String[] getBeanDefinitionNames();

}
