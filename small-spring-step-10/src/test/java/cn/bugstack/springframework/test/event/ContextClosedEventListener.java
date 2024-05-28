package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.event.ApplicationListener;
import cn.bugstack.springframework.event.template.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
