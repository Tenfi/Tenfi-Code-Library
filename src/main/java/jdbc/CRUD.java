package jdbc;

import java.sql.*;

/**
 * @author huangtengfei
 * @description 增删改查测试
 * @time 2021/6/7 18:46
 */
public class CRUD {
    public static void main(String[] args) {
        // 初始化需要插入的数据
        Student[] students = new Student[]{new Student("Tom", 12, "M"),
                new Student("Ming", 13, "W"), new Student("Wang", 12, "M")};
        // 获取连接:
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            // 插入，其中?表示占位符
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO public.javaBuild (name,age,gender) VALUES (?,?,?)")) {
                // 对同一个PreparedStatement反复设置参数并调用addBatch():
                for (Student student : students) {
                    // 设置对应占位符的值
                    ps.setObject(1, student.getName());
                    ps.setObject(2, student.getAge());
                    ps.setObject(3, student.getGender());
                    // 将每个完整的插入语句放进Batch
                    ps.addBatch();
                }
                // 执行batch:
                int[] ns = ps.executeBatch();
                for (int n : ns) {
                    // batch中每个SQL执行的结果数量
                    System.out.println(n + " has been inserted.");
                }
            }
            // 删除
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM public.javaBuild WHERE name='Tom'")) {
                int n = ps.executeUpdate();
                System.out.println(n + " has been deleted.");
            }
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

class Student {
    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
