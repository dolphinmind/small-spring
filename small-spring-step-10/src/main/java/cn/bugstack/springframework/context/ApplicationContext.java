package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.factory.interfaces.HierarchicalBeanFactory;
import cn.bugstack.springframework.beans.factory.interfaces.ListableBeanFactory;
import cn.bugstack.springframework.core.io.ResourceLoader;
import cn.bugstack.springframework.event.ApplicationEventPublisher;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 * <p>
 * 应用上下文
 * <p>
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
