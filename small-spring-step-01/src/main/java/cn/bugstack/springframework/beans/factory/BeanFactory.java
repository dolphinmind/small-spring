package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.bean.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 代表Bean对象的工厂，把Bedefinition当作包装盒，name为Bean的名字，Bean作为实体
 *              BeanFactory是对Bean制作过程的包装
 *              1. 先存在了Bean对象：名称+实体
 *              2. 将Bean对象放进标准盒子BeanDefinition构成个体
 *              3. 把名称+盒子实体 放进BeanFactory的容器当中
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
