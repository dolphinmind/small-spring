package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.event.ApplicationListener;
import cn.bugstack.springframework.event.template.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
