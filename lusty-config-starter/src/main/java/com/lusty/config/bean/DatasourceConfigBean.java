package com.lusty.config.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DatasourceConfigBean {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceConfigReposit dataSourceConfigReposit() throws SQLException {
        DataSourceConfigReposit reposit=new DataSourceConfigReposit(dataSource);
        return reposit;
    }
}
