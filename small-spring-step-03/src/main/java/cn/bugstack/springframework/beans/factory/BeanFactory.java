package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.exception.BeansException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    /**
     * @description 在上章的基础上添加的入参部分
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;
}
