package com.lusty.example.event;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventListener {

    @EventListener
    public void handMyEvent(MyEvent event){
        log.info("发布的数据{}", event.toString());
    }
}
