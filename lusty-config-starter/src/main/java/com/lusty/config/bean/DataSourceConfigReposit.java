package com.lusty.config.bean;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author lumeng
 */
@Slf4j
public class DataSourceConfigReposit {


    private DataSource dataSource;

    private static final String configTableName="lusty_data_config";

    public DataSourceConfigReposit(DataSource dataSource) throws SQLException {
        this.dataSource=dataSource;
        initTables();
    }


    private void initTables() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            createTaskResultTableIfNeeded(conn);
        }
    }


    private void createTaskResultTableIfNeeded(final Connection conn) throws SQLException {
        DatabaseMetaData dbMetaData = conn.getMetaData();
            try (ResultSet resultSet = dbMetaData.getTables(null, null, configTableName, new String[]{"TABLE"})) {
                if (!resultSet.next()) {
                    createTaskResultTable(conn, configTableName);
                }
            }

    }

    private void createTaskResultTable(final Connection conn, final String tableName) throws SQLException {
        String dbSchema = "CREATE TABLE `" + tableName + "` ("
                + "`id` BIGINT NOT NULL AUTO_INCREMENT, "
                + "`name` VARCHAR(20),"
                + "`value` VARCHAR(20),"
                + "`defalut_value` VARCHAR(20),"
                + "`create_time` TIMESTAMP NOT NULL,"
                + "`update_time` TIMESTAMP NOT NULL,"
                + "PRIMARY KEY (`id`));";
        try (PreparedStatement preparedStatement = conn.prepareStatement(dbSchema)) {
            preparedStatement.execute();
        }
    }

    public String getByKey(String key){
        String value=null;
        try{
            Connection connection = dataSource.getConnection();
            String sql="select value from "+configTableName+" where name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"value"});
            preparedStatement.setString(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               value= resultSet.getString(1);
            }
        }catch (Exception e){
           log.error("获取配置失败",e);
        }

    return value;
    }


}
