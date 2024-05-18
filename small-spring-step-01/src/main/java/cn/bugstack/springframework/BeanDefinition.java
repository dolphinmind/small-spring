package cn.bugstack.springframework;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 用于定义Bean实例化信息，用一个Object存放对象，BeanDefinition本身像一个容器装进Bean实体(仅本案例中)
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
