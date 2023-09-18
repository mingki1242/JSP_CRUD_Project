//package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/op")
public class ArithmeticCalc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ArithmeticCalc() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       StringBuilder sb = new StringBuilder();

       int check = 0;
       double answer = 0;

       String Input_num1 = request.getParameter("num1");
       String Input_num2 = request.getParameter("num2");
       String Input_operator = request.getParameter("operator");

       double num1 = Double.parseDouble(Input_num1);
       double num2 = Double.parseDouble(Input_num2);

       switch (Input_operator)
       {
           case  "+" :
               answer = num1+num2;
               break;
           case  "-" :
               answer = num1-num2;
               break;
           case  "*" :
               answer = num1*num2;
               break;
           case  "/" :
               if(num2 == 0)
               {

                   sb.append("<html><body><h2>").append("나눗셈 연산시 분모에 0은 입력 될 수 없습니다!!");
                   sb.append("<br>");
                   sb.append("<br>");
                   sb.append("<br> <a href = localhost:8080/chap1/op.html> 다시 계산 </a>");
                   sb.append("</h2></body></html>");
                   out.println(sb.toString());
                   return;
               }
               else {
                   answer = num1/num2;
               }
               break;


       }

       sb.append("<html><body><h2>계산 결과: ").append(request.getParameter("num1")).append(request.getParameter("operator")).append(request.getParameter("num2")).append("=").append(answer);
       sb.append("<br>");
       sb.append("<br>");
       sb.append("<br> <a href = localhost:8080/chap1/op.html> 다시 계산 </a>");
       sb.append("</h2></body></html>");
       out.println(sb.toString());






    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}


