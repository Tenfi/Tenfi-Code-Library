package JDBC;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/7 18:52
 */
public class ConnectionPool {
    // JDBC连接的URL,不同数据库有不同的格式:
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";
    static public HikariConfig config = new HikariConfig();


    public static void main(String[] args) {
        // 初始化连接池
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
        DataSource ds = new HikariDataSource(config);

        // 获取连接，把DriverManage.getConnection()改为ds.getConnection()
        try (Connection conn = ds.getConnection()) {
            // 查询
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.javaBuild")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + rs.getString("name") + rs.getInt("age") + rs.getString("gender"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
