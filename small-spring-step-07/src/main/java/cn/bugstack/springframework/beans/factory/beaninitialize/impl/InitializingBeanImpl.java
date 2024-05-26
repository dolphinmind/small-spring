package cn.bugstack.springframework.beans.factory.beaninitialize.impl;

import cn.bugstack.springframework.beans.factory.beaninitialize.InitializingBean;

/**
 * @ClassName InitializingBeanImpl
 * @Description
 * @Author dolphinmind
 * @Date 2024/5/24
 */

public class InitializingBeanImpl implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        // perform initialization
        if (null == name) {
            throw new IllegalArgumentException("The 'name' attribute is required");
        }

        System.out.println("Bean initialized with name " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
