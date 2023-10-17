package com.example.demo.news;

import java.sql.*;
import java.text.SimpleDateFormat;
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
                news.setRegdate(rs.getDate("regdate"));
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

    public int plusreadcnt(int articleId) {
        connect();
        int updatecnt = 0;
        String sql = "UPDATE news SET readcnt = readcnt + 1 WHERE id = ?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articleId);
            updatecnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return updatecnt;
    }

    public NewsVO getArticle(int articleId) {
        connect();
        ResultSet response = null;
        NewsVO article = null;
        String sql = "select * from news where id = ?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articleId);

            response = pstmt.executeQuery();
            if(response.next())
            {
                article = new NewsVO();
                article.setId(response.getInt("id"));
                article.setTitle(response.getString("title"));
                article.setWriter(response.getString("writer"));
                article.setRegdate(response.getDate("regdate"));
                article.setReadcnt(response.getInt("readcnt"));
                article.setBody(response.getString("body"));
            }

        } catch (SQLException e) {
            // 예외 처리 코드
            e.printStackTrace();
        } finally {
            // 리소스 해제
            if (response != null) {
                try {
                    response.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return article;
    }

    public int ChangeArticle(int articalId, String changeTitle, String changeBody, String changeWriter, String currentTime) {
        connect();
        int updatecount = 0;
        String sql = "UPDATE news SET title = ?, body = ?, writer = ?, regdate = ? WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,changeTitle);
            pstmt.setString(2,changeBody);
            pstmt.setString(3,changeWriter);
            pstmt.setString(4,currentTime);
            pstmt.setInt(5,articalId);

            updatecount = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // 예외 처리 추가
        } finally {
            // 리소스 해제
            disconnect();
        }
        return updatecount;

    }
}
