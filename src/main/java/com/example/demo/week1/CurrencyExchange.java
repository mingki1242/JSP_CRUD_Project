package com.example.demo.week1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex")
public class CurrencyExchange extends HttpServlet {
    public CurrencyExchange(){
        super();
    }
    private static final long serialVersionUID = 1L;
    private static final double wonUSD = 1340.02;
    private static final double wonJapan = 9.0406;
    private static final double wonEUR = 1428.84;
    private static final double wonChina = 183.26;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();


        int won = Integer.parseInt(request.getParameter("won"));
        System.out.println(won);

        sb.append("<html><body>");
        sb.append("<h2> 변환 결과 : </h2>");
        switch (request.getParameter("unit"))
        {
            case "달러" :
                sb.append(won/wonUSD).append("달러<p>");
                break;
            case "엔화" :
                sb.append(won/wonJapan).append("엔화<p>");;
                break;
            case "유로" :
                sb.append(won/wonEUR).append("유로<p>");;
                break;
            case "위안" :
                sb.append(won/wonChina).append("위안<p>");;
                break;

        }

        sb.append("<a href = \"exchange.html\"> 다시 계산 </a>");
        sb.append("</body></html>");
        out.println(sb.toString());
    }
}