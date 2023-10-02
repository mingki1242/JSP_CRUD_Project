package com.example.demo.week1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugu")
public class GuGuTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public GuGuTest(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();

        int dan = Integer.parseInt(request.getParameter("dan"));


        sb.append("<html><body><table><tr><td align = center colspan=2>");
        sb.append(dan).append("단</td></tr>");
        for(int i = 0 ;i<=9;i++)
        {
            sb.append("<tr><td align = center>");
            sb.append(String.format("%d * %d",dan,i)).append("</td>");
            sb.append("<td align = center>").append(dan*i).append("</td>></tr>");

        }
        sb.append("</table></body></html>");
        out.println(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}