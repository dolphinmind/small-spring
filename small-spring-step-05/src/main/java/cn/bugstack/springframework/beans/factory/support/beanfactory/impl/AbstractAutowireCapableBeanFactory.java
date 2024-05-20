package cn.bugstack.springframework.beans.factory.support.beanfactory.impl;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.beandefinition.PropertyValue;
import cn.bugstack.springframework.beans.factory.config.beandefinition.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanReference;
import cn.bugstack.springframework.beans.factory.support.instantiationstrategy.CglibSubclassingInstantiationStrategy;
import cn.bugstack.springframework.beans.factory.support.instantiationstrategy.InstantiationStrategy;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Constructor;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    // 指定Bean实例化策略
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 创建Bean实例
            bean = createBeanInstance(beanDefinition, beanName, args);

            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        // 遍历Bean类中的所有构造函数，选择与参数个数匹配的构造函数
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }
    /**
     * @description 该方法用于给指定的Bean实例填充属性值，属性值来源于Bean定义中的属性列表
     * @param beanName:当前Bean的名称，用于在异常处理时提供更好的错误信息
     * @param bean:当前Bean的实例，即待填充属性的对象
     * @param beanDefinition:当前Bean的BeanDefinition对象，包括了该Bean的属性信息
     *
     * 属性填充逻辑：
     * 1. 首先获取BeanDefinition中定义的属性列表:propertyValues
     * 2. 遍历属性列表
     * 3. 对于每个属性，获取属性的名称name和属性的值value
     * 4. 如果属性值是一个BeanReference类型，则说明当前Bean依赖于另一个Bean，需要先获取依赖Bean的实例，然后将其填充到当前Bean的属性中
     * 5. 最后使用BeanUtil.setFieldValue(bean, name, value) 方法将属性值设置到当前Bean实例中
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                // 如果属性值是一个BeanReference类型，表示当前Bean依赖于另一个Bean，
                // 则需要获取对应Bean的实例并将其填充到当前Bean的属性中
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
