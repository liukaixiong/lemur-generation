package cn.afterturn.gen.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;

/**
 * 数据库连接工具类 主要是创建连接
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public class ConnectionUtil {

    private static ThreadLocal<Connection> connection = new ThreadLocal<>();

    private ConnectionUtil() {

    }

    public static Statement createStatement() {
        if (connection.get() == null) {
            throw new GenerationRunTimeException("未发现数据库连接");
        }
        try {
            return connection.get().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            throw new GenerationRunTimeException("创建 Statement 发生异常", e);
        }
    }

    public static void init(String deiver, String url, String username, String passwd) {
        try {
            Class.forName(deiver);
            connection.set(DriverManager.getConnection(url, username, passwd));
        } catch (Exception e) {
            throw new GenerationRunTimeException("创建 Connection 发生异常", e);
        }
    }

    public static void close() {
        try {
            if (!connection.get().isClosed())
                connection.get().close();
        } catch (Exception e) {
            throw new GenerationRunTimeException("关闭 Connection 发生异常", e);
        }
    }

}
