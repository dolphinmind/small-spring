package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.exception.BeansException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
