package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/grade")
public class PrintGrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int total = Integer.parseInt(request.getParameter("id"))+
        Integer.parseInt(request.getParameter("name"))+
        Integer.parseInt(request.getParameter("middle"))+
        Integer.parseInt(request.getParameter("final"))+
        Integer.parseInt(request.getParameter("report"))+
        Integer.parseInt(request.getParameter("attendence"));
        request.setAttribute("total" , total);
        RequestDispatcher dispatcher;
        if(total > 60)
        {
            dispatcher = request.getRequestDispatcher("success");
        }
        else
        {
            dispatcher = request.getRequestDispatcher("fail");
        }
        dispatcher.forward(request ,response);

    }
}