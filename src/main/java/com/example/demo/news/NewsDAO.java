package com.example.demo.news;

import java.sql.*;
import java.util.ArrayList;

public class NewsDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    String jdbc_url = "jdbc:mysql://localhost:3306/spring4fs";

    void connect(){
        try{
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url , "root" , "marine102@");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void disconnect() {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<NewsVO> listNews(){
        connect();
        ArrayList<NewsVO> newslist = new ArrayList<>();
        String sql = "select * from news order by id";

        try{
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                NewsVO news = new NewsVO();
                news.setId(rs.getInt("id"));
                news.setReadcnt(rs.getInt("readcnt"));
                news.setTitle(rs.getString("title"));
                news.setWriter(rs.getString("writer"));
                news.setRegdate(rs.getString("regdate"));
                news.setBody(rs.getString("body"));
                newslist.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return newslist;
    }
}
