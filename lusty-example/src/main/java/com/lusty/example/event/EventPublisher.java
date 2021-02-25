package com.lusty.example.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    @Autowired
    private ApplicationContext applicationContext;


    public void pushEvent(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }
}
