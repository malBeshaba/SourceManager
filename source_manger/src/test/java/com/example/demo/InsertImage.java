package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class InsertImage {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/sourcemanagerdb?serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "candy123";

    protected Connection connect() {
        Connection connection = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(ResultSet rs, Statement stmt, Connection con) throws SQLException {
        if(rs!=null)
            rs.close();
        if(stmt!=null)
            stmt.close();
        if(con!=null)
            con.close();
    }

    public boolean insert(int id, String path) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.connect();
            String sql = "insert into sourcemanagerdb.source_image(source_id, image) values(?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            InputStream in = new FileInputStream(new File(path));
            stmt.setBinaryStream(2, in);
            int result = stmt.executeUpdate();
            System.out.println("success: insert to image. line:"+result);
            return true;
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            this.close(rs, stmt, conn);
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        InsertImage insertImage = new InsertImage();
        insertImage.insert(4, "C:\\Users\\Gantlas\\Desktop\\try.png");
        insertImage.insert(5, "C:\\Users\\Gantlas\\Desktop\\try.png");
        insertImage.insert(6, "C:\\Users\\Gantlas\\Desktop\\try.png");
        insertImage.insert(7, "C:\\Users\\Gantlas\\Desktop\\try.png");
        insertImage.insert(8, "C:\\Users\\Gantlas\\Desktop\\try.png");
        insertImage.insert(9, "C:\\Users\\Gantlas\\Desktop\\try.png");
        insertImage.insert(10, "C:\\Users\\Gantlas\\Desktop\\try.png");

    }
}
