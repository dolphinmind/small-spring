package cn.bugstack.springframework.beans.bean;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 定义本身就是一种容器，容器里面装有bean的元数据
 */
public class BeanDefinition {
    // 表示Bean的类对象
    private Class beanClass;

    // 表示Bean的属性值集合
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
