package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fail")
public class fail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body>");
        sb.append("<h2>점수가 60점 미만 입니다</h2><p>");
        sb.append("학번 : ").append(request.getParameter("id")).append("<br>");
        sb.append("이름 : ").append(request.getParameter("name")).append("<br><p>");
        sb.append("중간고사 : ").append(request.getParameter("middle")).append("<br>");
        sb.append("기말고사 : ").append(request.getParameter("final")).append("<br>");
        sb.append("레포트 : ").append(request.getParameter("report")).append("<br>");
        sb.append("출석 : ").append(request.getParameter("attendence")).append("<p>");
        sb.append("총점 : ").append(request.getParameter("total")).append("<p>");

        sb.append("</body></html>");
        out.println(sb.toString());
    }
}