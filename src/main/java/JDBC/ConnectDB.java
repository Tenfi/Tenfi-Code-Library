package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author huangtengfei
 * @description 测试数据的连接
 * @time 2021/6/7 18:29
 */
public class ConnectDB {
    // JDBC连接的URL,不同数据库有不同的格式:
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        // 获取连接:
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("数据库连接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
