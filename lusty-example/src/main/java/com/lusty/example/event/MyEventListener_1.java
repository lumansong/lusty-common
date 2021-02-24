package com.lusty.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventListener_1 {

    @EventListener
    public void handMyEvent(MyEvent event){
        log.info("发布的数据{}", event.toString());
    }
}
