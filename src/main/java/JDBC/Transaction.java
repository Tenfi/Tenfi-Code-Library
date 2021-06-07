package JDBC;

import java.sql.*;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/7 18:49
 */

public class Transaction {
    // JDBC连接的URL,不同数据库有不同的格式:
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Savepoint savepoint = null;
        try {
            // 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 设定隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            // 关闭自动提交，相当于SQL语句中的BEGAIN
            conn.setAutoCommit(false);
            // 插入操作1
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO public.javaBuild (name,age,gender) VALUES ('Huang',12,'M')")) {
                ps.executeUpdate();
            }
            // 设置保存点
            savepoint = conn.setSavepoint("Savepoint");
            // 插入操作2
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO public.javaBuild (name,age,gender) VALUES ('Dong',12,11111)")) {
                ps.executeUpdate();
            }
            // 提交事务
            conn.commit();
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
            // 回滚事务
            if (conn != null) {
                conn.rollback(savepoint);
            }
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}