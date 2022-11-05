package com.zx.myssm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName Connections
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/12 19:34
 * @Version 1.0
 */
public class Connections {
    private Connections() {
    }

    static DataSource dataSource;

    static {
        try {
            InputStream resourceAsStream = Connections.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (null == connection) {
                connection = dataSource.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
