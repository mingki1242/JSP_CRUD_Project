package com.example.demo.week1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/success")
public class success extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public success(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body>");
        int grade = Integer.parseInt(request.getParameter("id"));
        int name = Integer.parseInt(request.getParameter("name"));
        int middle = Integer.parseInt(request.getParameter("middle"));
        int _final = Integer.parseInt(request.getParameter("final"));
        int report = Integer.parseInt(request.getParameter("report"));
        int attendence = Integer.parseInt(request.getParameter("attendence"));

        int result = grade + name + middle + _final + report + attendence;

        *//*if(result > 60)
        {
            sb.append("<html><body>");
        }*//*
        sb.append("<html><body>");
        sb.append("<h2>성적을 취득 하였습니다</h2>");
        sb.append("학번 : ")
        */

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body>");
        sb.append("<h2>성적을 취득 하였습니다</h2><p>");
        sb.append("학번 : ").append(request.getParameter("id")).append("<br>");
        sb.append("이름 : ").append(request.getParameter("name")).append("<br><p>");
        sb.append("중간고사 : ").append(request.getParameter("middle")).append("<br>");
        sb.append("기말고사 : ").append(request.getParameter("final")).append("<br>");
        sb.append("레포트 : ").append(request.getParameter("report")).append("<br>");
        sb.append("출석 : ").append(request.getParameter("attendance")).append("<p>");
        sb.append("총점 : ").append(request.getAttribute("total")).append("<p>");

        sb.append("</body></html>");
        out.println(sb.toString());
    }
}