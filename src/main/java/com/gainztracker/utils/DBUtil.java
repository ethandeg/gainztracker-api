package com.gainztracker.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        try (InputStream inputStream = DBUtil.class.getResourceAsStream("/db.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            config.setJdbcUrl(properties.getProperty("db.url"));
            config.setUsername(properties.getProperty("db.username"));
            config.setPassword(properties.getProperty("db.password"));
            config.setMaximumPoolSize(10);
            config.setDriverClassName("org.postgresql.Driver");
            dataSource = new HikariDataSource(config);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load database configuration", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
