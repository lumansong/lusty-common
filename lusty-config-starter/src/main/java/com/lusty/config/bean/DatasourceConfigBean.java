package com.lusty.config.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@ConditionalOnProperty(value = "lusty.config.enabled", matchIfMissing = true)
public class DatasourceConfigBean {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceConfigReposit dataSourceConfigReposit() throws SQLException {
        DataSourceConfigReposit reposit=new DataSourceConfigReposit(dataSource);
        return reposit;
    }
}
