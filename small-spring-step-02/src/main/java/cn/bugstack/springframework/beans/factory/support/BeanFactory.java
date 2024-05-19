package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.BeansException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
