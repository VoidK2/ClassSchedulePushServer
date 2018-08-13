package com.zzx;

import java.sql.*;
public class db {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String titletext;
    private String contenttext;
    private String expandcontext;
    private int expandType;
//    展开方式 (0, "标准"),(1, "文本")
    public void dbConnect(String sql) {

        String DB_URL = "jdbc:mysql://34.236.145.58:3306/CT";
        String USER = "root";
        String PASS = "123456";

        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("---已查询数据库---");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void db2msgNextDay() throws Exception {
        if(rs.next()==true){
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

            msg s1 = new msg();
            s1.pushmsg(titletext,contenttext,expandcontext,expandType);
        }
    }
    public void db2msgNextHour() throws Exception {
        if(rs.next()==true){
            titletext = rs.getString("name");
            contenttext = rs.getInt("stime")
                    +"-"+rs.getInt("etime")
                    +"  "+rs.getString("teacher")
                    +"  "+rs.getString("place");
            expandType = 0;
            expandcontext = null;
        }
    }



}
