package cn.bugstack.springframework.beans.bean;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 *
 * @description 简单地封装了对另一个Bean的名称引用
 *              在loC容器中，当一个Bean依赖于另一个Bean时，通常实用BeanReference对象来表示对依赖Bean的引用
 *              这样的设计使得可以更灵活地处理Bean之间的依赖关系
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
