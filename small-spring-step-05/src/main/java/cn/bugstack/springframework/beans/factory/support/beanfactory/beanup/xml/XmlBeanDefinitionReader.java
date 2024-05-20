package cn.bugstack.springframework.beans.factory.support.beanfactory.beanup.xml;

import cn.bugstack.springframework.beans.factory.config.BeansException;
import cn.bugstack.springframework.beans.factory.config.beandefinition.PropertyValue;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanReference;
import cn.bugstack.springframework.beans.factory.support.beanfactory.beanup.AbstractBeanDefinitionReader;
import cn.bugstack.springframework.beans.factory.config.beandefinition.BeanDefinitionRegistry;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * Bean definition reader for XML bean definitions.
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    // 接口方法实现
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()){
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    // 接口方法实现
    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    // 接口方法实现
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    // 主要作用是从XML中读取bean的定义信息
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {

        // 从给定的inputStream中读取XM数据，并使用XmlUtil工具类将其解析为一个Document对象
        Document doc = XmlUtil.readXML(inputStream);

        // 从Document对象中获取XML文档的根元素
        Element root = doc.getDocumentElement();

        // 获取根元素下的所有子节点
        NodeList childNodes = root.getChildNodes();

        // 遍历根元素的所有子节点
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 如果当前子节点不是Element类型，则跳过当前循环，继续下一次循环
            if (!(childNodes.item(i) instanceof Element)) continue;

            // 如果当前子节点不是名称为bean的元素，则跳过当前循环，继续下一次循环
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;
            
            // 将当前子节点强制转换为Element类型，表示这是一个bean元素
            Element bean = (Element) childNodes.item(i);

            // 获取bean元素的id属性值
            String id = bean.getAttribute("id");

            // 获取bean元素的name属性值
            String name = bean.getAttribute("name");

            // 获取bean元素的class属性值，即bean对应的类的全限定名
            String className = bean.getAttribute("class");

            // 根据类的全限定名加载对应的Class对象
            Class<?> clazz = Class.forName(className);

            // 确定Bean的名称，优先级 id > name，如果没有则使用name属性，如果都没有则使用类名的小写形式
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 创建一个BeanDefinition对象，将加载的类信息传入
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            // 遍历当前bean元素的所有子节点
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {

                // 如果当前子节点不是Element类型，则跳过当前循环，继续下一次循环
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;

                // 如果当前子节点不是名称为property的元素，则跳过当前循环，继续下一次循环
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                // 解析标签：property，将当前子节点强制转换为Element类型，表示这是一个属性元素
                Element property = (Element) bean.getChildNodes().item(j);

                // 获取属性元素的name属性值，即属性名称
                String attrName = property.getAttribute("name");

                // 获取属性元素的value属性值，即属性的值
                String attrValue = property.getAttribute("value");

                // 获取属性元素的ref属性值，即属性引用的bean的名称
                String attrRef = property.getAttribute("ref");

                // 获取属性值：引入对象、值对象。根据属性是否引用其他bean来确定属性的值，如果引用了其他bean，则创建一个BeanReference对象，否则直接使用属性值
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                // 创建属性对象，表示属性的名称和值
                PropertyValue propertyValue = new PropertyValue(attrName, value);

                // 将属性信息添加到BeanDefinition对象的属性值列表中
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            // 检查是否已经注册了同名的bean
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            // 将当前bean的定义注册到bean定义的注册表中
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

}
