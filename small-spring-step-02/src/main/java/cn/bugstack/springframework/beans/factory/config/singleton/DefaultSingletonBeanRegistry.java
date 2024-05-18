package cn.bugstack.springframework.beans.factory.config.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description singletonObjects装入的是实体对象
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
