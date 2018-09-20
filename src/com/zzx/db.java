package com.zzx;

import java.sql.*;
public class db {
    private Connection conn;
    private Statement stmt;
    public ResultSet rs = null;
    private String titletext = null;
    private String contenttext = null;
    private String expandcontext = null;
    private int expandType = 0;
//    展开方式 (0, "标准"),(1, "文本")
    public void dbConnect(String sql) {

        String DB_URL = "jdbc:mysql://39.108.90.113:3306/classtable";
        String USER = "root";
        String PASS = "ALIyun270400.";

        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("---已查询数据库---");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void db2msgNextDay() throws Exception {
        if(rs.next()){
            titletext = "明天有课(,,•́ . •̀,,)早点休息";
            contenttext = rs.getString("name")
                    +" "+rs.getInt("stime")
                    +"-"+rs.getInt("etime")
                    +" "+rs.getString("teacher")
                    +" "+rs.getString("place");
            expandcontext = contenttext+"\n";
            while(rs.next()){
                expandType = 1;
                expandcontext = expandcontext
                        +rs.getString("name")
                        +" "+rs.getInt("stime")
                        +"-"+rs.getInt("etime")
                        +" "+rs.getString("teacher")
                        +" "+rs.getString("place")
                        +"\n";
            }

        }else{
            titletext = "明天没课(つд⊂)";
            contenttext = "注意劳逸结合哦";
            expandType = 0;
            expandcontext = null;

        }
        msg s1 = new msg();
        s1.pushmsg(titletext,contenttext,expandcontext,expandType);
    }
    public void db2msgNextHour() throws Exception {
        if(rs.next()){
            titletext = rs.getString("name");
            contenttext = rs.getInt("stime")
                    +"-"+rs.getInt("etime")
                    +"  "+rs.getString("teacher")
                    +"  "+rs.getString("place");
            expandType = 0;
            expandcontext = null;
        }
        msg s2 = new msg();
        s2.pushmsg(titletext,contenttext,expandcontext,expandType);
    }



}
