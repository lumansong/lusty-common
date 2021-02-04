//package com.lusty.datasource.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * 描述：配置类
// *
// * @Author shf
// * @Date 2019/5/7 21:50
// * @Version V1.0
// **/
//@Configuration
//@EnableConfigurationProperties(MasterDataSourceProperties.class)
//@ConditionalOnProperty(
//        prefix = "spring.datasource.master",
//        name = "isopen",
//        havingValue = "true"
//)
//public class MasterDataSourceConfig {
//    @Autowired
//    private MasterDataSourceProperties masterDataSourceProperties;
//
//    @Bean(name = "demo")
//    public DataSource demoService(){
//     return new DemoService(demoProperties.getSayWhat(), demoProperties.getToWho());
//
//    }
//
//}
