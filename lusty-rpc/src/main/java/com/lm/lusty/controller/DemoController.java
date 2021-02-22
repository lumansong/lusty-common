package com.lm.lusty.controller;


import com.lm.lusty.rpcInterface.DubboRpcDemo;
import com.lm.lusty.rpcInterface.LustyRpcDemo;
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

    @Autowired
    private LustyRpcDemo lustyRpcDemo;

    @Autowired
    private DubboRpcDemo dubboRpcDemo;

    @RequestMapping("/testrpc")
    public String testrpc(){
        return lustyRpcDemo.show();
    }

    @RequestMapping("/testRpcParam")
    public String testRpcParam(){
        return lustyRpcDemo.showParam("hejjj",1);
    }

    @RequestMapping("/testDubbo")
    public String testDubbo(){
        return dubboRpcDemo.showParam("dubbo",1);
    }
}
