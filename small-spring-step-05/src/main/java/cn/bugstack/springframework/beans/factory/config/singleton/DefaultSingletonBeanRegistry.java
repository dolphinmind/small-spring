package cn.bugstack.springframework.beans.factory.config.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 单例对象集合，缓存
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
