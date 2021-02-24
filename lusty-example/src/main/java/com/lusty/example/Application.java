package com.lusty.example;

//import com.lusty.config.anno.EnableLustyConfig;
import com.lusty.datasource.config.DynamicDataSourceAspect;
import com.lusty.datasource.config.anno.EnableDyDataSource;
import demo.anno.EnableDemo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableDemo
//@EnableDyDataSource
//@EnableLustyConfig
//@MapperScan(basePackages = "com.lusty.example.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
