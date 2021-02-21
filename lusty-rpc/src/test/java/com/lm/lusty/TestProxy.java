package com.lm.lusty;


import com.lm.lusty.rpcInterface.LustyRpcDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RpcApplication.class})
public class TestProxy {

    @Autowired
    private LustyRpcDemo lustyRpcDemo;

    @Test
    public void  testPrint(){
        lustyRpcDemo.print();
    }

}
