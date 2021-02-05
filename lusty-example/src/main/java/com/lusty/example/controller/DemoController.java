package com.lusty.example.controller;


import com.lusty.example.entity.GroupSendBean;
import com.lusty.example.mapper.GroupSendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/say")
//    public String sayWhat(){
//        return demoService.say();
//    }

    @GetMapping("/testDataSource")
    public GroupSendBean testDataSource(){
        return groupSendMapper.selectByPrimaryKey(39L);
    }

}
