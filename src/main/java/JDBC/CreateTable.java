package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/7 18:43
 */
public class CreateTable {
    public static void main(String[] args) {
        // 获取连接:
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");) {
            // Statement对象用于执行SQL语句
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE public.javaBuild" +
                        " (id serial PRIMARY KEY NOT NULL," +
                        " name text ," +
                        " age  int," +
                        " gender char(1))";
                stmt.executeUpdate(sql);
            }
            System.out.println("JAVA建表成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
