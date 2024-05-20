package cn.bugstack.springframework.beans.factory.support.beanfactory.beanup;

import cn.bugstack.springframework.core.io.impl.DefaultResourceLoader;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * Abstract base class for bean definition readers which implement
 * the {@link BeanDefinitionReader} interface.
 * <p>
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 *
 * @description AbstractBeanDefinitionReader类提供了一些基本的实现，包括注册表和资源加载器的初始化
 *              以及对应的getRegistry()和getResourceLoader()方法。子类可以继承这个抽象类，并实现具体的
 *              loadBeanDefinitions()方法，以实现从不同的资源中加载Bean的定义信息
 *              通过这样的设计，Spring框架提供了一种灵活的机制来加载和管理Bean的定义，从而实现了依赖注入和控制反转的功能
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    // BeanDefinition注册表，用于存储和管理Bean的定义信息
    private final BeanDefinitionRegistry registry;

    // 资源加载器，用于加载外部资源(如配置文件、注解等)
    private ResourceLoader resourceLoader;

    // 创建一个默认的资源加载器
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    // 初始化注册表和资源加载器
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    // 返回注册表对象，用于管理Bean的定义信息
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    // 返回资源加载器对象，用于加载外部资源
    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
