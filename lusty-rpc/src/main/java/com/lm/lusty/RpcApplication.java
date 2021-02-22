package com.lm.lusty;


import com.lm.lusty.anno.EnableLuRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableLuRpc(scanPath = {"com.lm.lusty"})
public class RpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcApplication.class, args);
    }
}
