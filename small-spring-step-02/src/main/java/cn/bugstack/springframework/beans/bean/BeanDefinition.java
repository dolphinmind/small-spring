package cn.bugstack.springframework.beans.bean;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 定义BeanClass容器
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

//    public void addBeanClass(Class beanClass) {
//        this.beanClass = beanClass;
//    }
}
