package com.example.demo.week3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login/*")
public class loginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        memberDAO = new MemberDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request,response);
    }



    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();

        System.out.println("action: " + action);

        if(action == null)
        {
            nextPage = "/week3/index.jsp";
        }
        else if(action.equals("/login.do"))
        {
            if(request.getMethod().equalsIgnoreCase("GET"))
            {
                nextPage = "/week3/login.jsp";
            }
            else {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                HashMap<String , Boolean> errors = new HashMap<>();
                request.setAttribute("errors" , errors);
                if(email == null || email.isEmpty())
                {
                    errors.put("email" , true);
                }
                if(password == null || password.isEmpty())
                {
                    errors.put("password" , true);
                }

                if(!errors.isEmpty())
                {
                    nextPage = "/week3/login.jsp";
                }

                else{
                    MemberVO member = memberDAO.getMemberByEmail(email);
                    if(!password.equals(member.getPassword()))
                    {
                        errors.put("notMatch" , true);
                        nextPage = "/week3/login.jsp";
                    }
                    else {
                        request.getSession().setAttribute("authUser" , member);
                        nextPage = "/week3/index.jsp";
                    }
                }
            }
        }
        else if(action.equals("/logout.do"))
        {
            HttpSession session = request.getSession(false);
            if(session != null)
            {
                session.invalidate();
            }
            nextPage = "/week3/index.jsp";
        }
        else if(action.equals("/changepwd.do"))
        {
            if(request.getMethod().equalsIgnoreCase("GET"))
            {
                nextPage = "/week3/changePassword.jsp";
            }
            else {
                HttpSession session = request.getSession(false);
                MemberVO member = (MemberVO) session.getAttribute("authUser");

                if(member == null)
                {
                    nextPage = "/week3/index.jsp";
                }
                HashMap<String , Boolean> error = new HashMap<>();
                String currentpwd = request.getParameter("cpass");
                String newpwd = request.getParameter("npass");
                request.setAttribute("error" , error);
                if(currentpwd == null || currentpwd.isEmpty())
                {
                    error.put("currentpwd" , true);
                }
                if(newpwd ==null || newpwd.isEmpty())
                {
                    error.put("newpwd" , true);
                }
                if(!error.isEmpty())
                {
                    nextPage = "/week3/changePassword.jsp";
                }
                else {
                    if(currentpwd.equals(member.getPassword()))
                    {
                        member.setPassword(newpwd);
                        memberDAO.updateMember(member);
                        error.put("success" , true);
                        nextPage = "/week3/changePassword.jsp";
                    }
                    else {
                        error.put("notmatch" , true);
                        nextPage = "/week3/changePassword.jsp";
                    }
                }

            }
        }

        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }
}