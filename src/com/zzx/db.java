package com.zzx;

import java.sql.*;
public class db {
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    public void dbConnect(String sql) {

        String DB_URL = "jdbc:mysql://34.236.145.58:3306/CT";
        String USER = "root";
        String PASS = "123456";

        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getCname() throws SQLException {
        return rs.getString("name");
    }

    public String getStime() throws SQLException {
        return rs.getString("stime");
    }

    public String getEtime() throws SQLException {
        return rs.getString("etime");
    }

    public String getWeek() throws SQLException {
        return rs.getString("week");
    }

    public String getSweek() throws SQLException {
        return rs.getString("sweek");
    }

    public String getEweek() throws SQLException {
        return rs.getString("eweek");
    }

    public String getPlace() throws SQLException {
        return rs.getString("place");
    }

    public String getTeacher() throws SQLException {
        return rs.getString("teacher");
    }

    public void dbClose() throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }



}
