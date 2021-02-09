package com.lusty.example.controller;


import com.lusty.aop.bean.User;
import com.lusty.aop.interceptor.UserInfoThreadLocalContext;
import com.lusty.config.bean.DataSourceConfigReposit;
import com.lusty.config.bean.DatasourceConfigBean;
import com.lusty.example.entity.GroupSendBean;
import com.lusty.example.event.MyEvent;
import com.lusty.example.mapper.GroupSendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @Author shf
 * @Description TODO
 * @Date 2019/5/13 15:52
 * @Version V1.0
 **/
@RestController
public class DemoController {
//    @Autowired
//    private DemoService demoService;

    @Autowired
    private GroupSendMapper groupSendMapper;

    @Autowired(required = false)
    private DataSourceConfigReposit reposit;

//    @GetMapping("/say")
//    public String sayWhat(){
//        return demoService.say();
//    }

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/testDataSource")
    public GroupSendBean testDataSource(){
        return groupSendMapper.selectByPrimaryKey(39L);
    }


    @GetMapping("/getByKey/{key}")
    public String testDataSource(@PathVariable String key){
        return reposit.getByKey(key);
    }


    @RequestMapping("/testListener")
    public String testListener(){
        applicationContext.publishEvent(new MyEvent(this,"鲁猛","测试发布事件"));
        return "success";
    }

    @RequestMapping("/testIncept")
    public User testIncept(){
        User user = UserInfoThreadLocalContext.getUser();
        return user;
    }


}
