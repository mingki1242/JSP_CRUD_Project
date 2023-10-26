//package com.example.demo.week3;
//
//import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//
//import java.io.IOException;
//import java.util.HashMap;
//
//@WebServlet("/login/*")
//public class loginController2 extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    MemberDAO memberDAO;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public loginController2() {
//        memberDAO = new MemberDAO();
//    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doHandle(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doHandle(request, response);
//    }
//
//    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String nextPage = null;
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        String action = request.getPathInfo();
//
//        System.out.println("action: " + action);
//
//        if(action.equals("/login.do"))
//        {
//            if(request.getMethod().equalsIgnoreCase("GET"))
//            {
//                nextPage = "/week3/login.jsp";
//            }
//            else {
//                String email = request.getParameter("email");
//                String password = request.getParameter("password");
//                HashMap<String , Boolean> errors = new HashMap<>();
//
//                request.setAttribute("errors" , errors);
//                if(email == null || email.isEmpty())
//                {
//                    errors.put("email" , true);
//                }
//                if(password == null || password.isEmpty())
//                {
//                    errors.put("password" , true);
//                }
//                if(!errors.isEmpty())
//                {
//                    nextPage = "/week3/login.jsp";
//                }
//                else {
//                    MemberVO member;
//                    member = memberDAO.getMemberByEmail(email);
//                    if(password.equals(member.getPassword()))
//                    {
//                        HttpSession session = request.getSession(false);
//                        session.setAttribute("userAuth" , member);
//                        nextPage = "/week3/index.jsp";
//                    }
//                    else {
//                        errors.put("notMatch" , true);
//                        nextPage = "/week3/login.jsp";
//                    }
//                }
//            }
//        }
//        else if(action.equals("/changepwd.do"))
//        {
//            if(request.getMethod().equalsIgnoreCase("GET"))
//            {
//                nextPage = "/week3/changepwd.jsp";
//            }
//            else {
//                String oldpass = request.getParameter("current_pass");
//                String newpass = request.getParameter("changefin_pass");
//                HashMap<String , Boolean> errors = new HashMap<>();
//                request.setAttribute("errors" , errors);
//                if(oldpass == null || oldpass.isEmpty())
//                {
//                    errors.put("oldpass"  , true);
//                }
//                if(newpass == null || newpass.isEmpty())
//                {
//                    errors.put("newpass" , true);
//                }
//                if(!errors.isEmpty())
//                {
//                    nextPage = "/week3/changepwd.jsp";
//                }
//                else {
//                    HttpSession session = request.getSession(false);
//                    MemberVO member = (MemberVO) session.getAttribute("userAuth");
//                    if(oldpass.equals(member.getPassword()))
//                    {
//                        member.setPassword(newpass);
//                        memberDAO.updateMember(member);
//                        nextPage = "/week3/index.jsp";
//                    }
//                    else {
//                        errors.put("notMatch" , true);
//                    }
//                }
//            }
//        }
//        else if(action.equals("/logout.do"))
//        {
//            HttpSession session = request.getSession(false);
//
//            if(!(session == null))
//            {
//
//            }
//        }
//
//
//
//        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
//        dispatch.forward(request, response);    }
//
//}