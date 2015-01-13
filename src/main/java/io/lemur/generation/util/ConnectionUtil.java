package io.lemur.generation.util;

import io.lemur.generation.exception.GenerationRunTimeException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库连接工具类 主要是创建连接
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public class ConnectionUtil {

    private static Connection connection;

    private ConnectionUtil() {

    }

    private static ConnectionUtil instance;

    public static Statement createStatement() {
        if (instance == null) {
            init();
        }
        try {
            return connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            throw new GenerationRunTimeException("创建 Statement 发生异常", e);
        }
    }

    private static void init() {
        try {
            Class.forName(PropertiesUtil.getString(PropertiesUtil.DB_DRIVER));
            connection = DriverManager.getConnection(
                PropertiesUtil.getString(PropertiesUtil.DB_URL),
                PropertiesUtil.getString(PropertiesUtil.DB_USER_NAME),
                PropertiesUtil.getString(PropertiesUtil.DB_PASSWORD));
        } catch (Exception e) {
            throw new GenerationRunTimeException("创建 Connection 发生异常", e);
        }
    }

}
