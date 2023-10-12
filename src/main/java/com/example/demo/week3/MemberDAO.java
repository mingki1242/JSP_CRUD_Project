package com.example.demo.week3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    String jdbc_url = "jdbc:mysql://localhost:3306/spring4fs";

    void connect() {
        try {
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url, "root", "marine102@"); // 수정 필요
        } catch (Exception e) {
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

    public ArrayList<MemberVO> listMembers() {
        connect();
        ArrayList<MemberVO> list = new ArrayList<>();
        String sql = "select * from member order by id";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberVO member = new MemberVO();
                member.setId(rs.getInt("id"));
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setRegdate(rs.getString("regdate"));
                list.add(member);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return list;
    }
}
