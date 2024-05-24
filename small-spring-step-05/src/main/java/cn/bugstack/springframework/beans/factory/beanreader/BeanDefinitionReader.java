package cn.bugstack.springframework.beans.factory.beanreader;

import cn.bugstack.springframework.exception.BeansException;
import cn.bugstack.springframework.beans.factory.beanregistry.BeanDefinitionRegistry;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 接口定义了一系列方法，用于加载和读取Bean的定义信息。
 *              通过这些方法，可以从不同的资源中加载Bean的定义，然后将其注册到BeanDefinitionRegistry中
 *              这样的设计使得Spring容器可以灵活地从不同的来源加载Bean的定义，从而实现了更强大的配置管理功能
 */
public interface BeanDefinitionReader {
    // 获取与此读取器关联的BeanDefinitionRegistry对象,通过该方法可以获取注册BeanDefinition的注册表
    BeanDefinitionRegistry getRegistry();

    // 获取与此读取其关联的ResourceLoader对象，通过该方法可以获取用于加载资源的资源加载器
    ResourceLoader getResourceLoader();

    // 从给定的资源加载Bean的定义信息，一般情况下，资源可以是文件、类路径或者远程URL
    void loadBeanDefinitions(Resource resource) throws BeansException;

    // 从给定的多个资源加载Bean的定义信息，允许一次性加载多个资源中的Bean定义
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    //  从给定位置的资源加载Bean的定义信息，位置可以是文件路径、类路径或远程URL
    void loadBeanDefinitions(String location) throws BeansException;

}
