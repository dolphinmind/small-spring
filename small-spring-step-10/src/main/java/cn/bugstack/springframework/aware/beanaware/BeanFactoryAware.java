package cn.bugstack.springframework.aware.beanaware;

import cn.bugstack.springframework.aware.Aware;
import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.factory.factorybean.BeanFactory;

/**
 * Interface to be implemented by beans that wish to be aware of their
 * owning {@link BeanFactory}.
 *
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanFactoryAware extends Aware {

   void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
