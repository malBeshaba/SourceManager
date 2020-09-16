package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.SourceImage;
import com.example.demo.repository.SourceImageRepository;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SourceImageService {
    @Autowired
    private SourceImageRepository repository;

    private JSONObject getJsonResult(Iterable iterable, String msg){
        List<SourceImage> imageList=new ArrayList<>();
        for (Object source:iterable) {
            imageList.add((SourceImage) source);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg",msg);
        jsonObject.put("data",imageList);
        return jsonObject;
    }

    public JSONObject addSourceImage(int source_id, String path) {
        try {
            InputStream in = new FileInputStream(new File(path));
            repository.addSourceImage(source_id, in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","success");
        return jsonObject;
    }

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

    public byte[] getImage(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        byte[] buff = null;
        try {
            connection = this.connect();
            String sql = "select image from sourcemanagerdb.source_image where source_id=?";
            stat = connection.prepareStatement(sql);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getAsciiStream("image");
                buff = new byte[in.available()];
                in.read(buff, 0, in.available());
                in.close();
            }
            System.out.println("success: select image from image. id:"+id);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.close(rs, stat, connection);
        }
        return buff;
    }

    public boolean insert(int source_id, MultipartFile file) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.connect();
            String sql = "insert into sourcemanagerdb.source_image(source_id, image) values(?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, source_id);
            InputStream in = file.getInputStream();
            stmt.setBinaryStream(2, in);
            int result = stmt.executeUpdate();
            System.out.println("success: insert to sourceimage. line:"+result);
            return true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.close(rs, stmt, conn);
        }
        return false;
    }
}
