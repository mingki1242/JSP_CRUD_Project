package com.example.demo.week3;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        memberDAO = new MemberDAO();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doHandle(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();

        System.out.println("action: " + action);

        if (action == null || action.equals("/listMembers.do")) {
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/week3/listMembers.jsp";
        }
        else if (action.equals("/insertReq.do"))
        {
            nextPage = "/week3/insert.jsp";
        }
        else if(action.equals("/insert.do"))
        {
            MemberVO reg_member = new MemberVO();
            reg_member.setEmail(request.getParameter("email"));
            reg_member.setName(request.getParameter("name"));
            reg_member.setRegdate(request.getParameter("regdate"));
            reg_member.setPassword(request.getParameter("password"));
            memberDAO.insertMember(reg_member);

            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/week3/listMembers.jsp";
        }
        else if(action.equals("/updateReq.do"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            MemberVO member = memberDAO.getMemberByid(id);
            request.setAttribute("member" , member);
            nextPage = "/week3/update.jsp";
        }
        else if(action.equals("/delete.do"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            memberDAO.deleteMember(id);
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/week3/listMembers.jsp";
        }
        else if(action.equals("/update.do"))
        {
            MemberVO member = new MemberVO();
            member.setEmail(request.getParameter("email"));
            member.setName(request.getParameter("name"));
            member.setRegdate(request.getParameter("regdate"));
            member.setPassword(request.getParameter("password"));
            member.setId(Integer.parseInt(request.getParameter("id")));
            memberDAO.updateMember(member);

            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/week3/listMembers.jsp";
        }

        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }
}

