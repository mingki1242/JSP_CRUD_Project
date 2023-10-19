package com.example.demo.news;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/news/*")
public class NewsController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    NewsDAO newsDAO;

    public NewsController()
    {newsDAO = new NewsDAO();}

    public static String getTodayDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doHandle(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();

        if(action == null || action.equals("/list.do"))
        {

            List<NewsVO> newslist = newsDAO.listNews();
            request.setAttribute("newslist" , newslist);
            nextPage = "/news_jsp/list.jsp";
        }
        else if(action.equals("/read.do") || action.equals("/news/read.do"))
        {
            int articleId = Integer.parseInt(request.getParameter("id"));

            int readcountPlus = newsDAO.plusreadcnt(articleId);
            NewsVO article = newsDAO.getArticle(articleId);
            request.setAttribute("article" , article);
            nextPage = "/news_jsp/article.jsp";
        }
        else if(action.equals("/update.do"))
        {
            int articleId = Integer.parseInt(request.getParameter("id"));
            NewsVO currentNews = newsDAO.getArticle(articleId);

            if(currentNews != null)
            {
                request.setAttribute("article" , currentNews);
                nextPage = "/news_jsp/update.jsp";
            }
            else {
                System.out.println("error");
            }
        }
        else if(action.equals("/update.fin"))
        {
            int articleId = Integer.parseInt(request.getParameter("id"));
            String changeTitle = request.getParameter("title");
            String changeBody = request.getParameter("body");
            String changeWriter = request.getParameter("writer");
            String currentTime = getTodayDate();

            int success_update = newsDAO.ChangeArticle(articleId , changeTitle , changeBody , changeWriter , currentTime);

            if(success_update > 0)
            {
                List<NewsVO> finalNewsList = newsDAO.listNews();
                request.setAttribute("newslist" , finalNewsList);
                nextPage = "/news_jsp/list.jsp";
            }
            else {
                System.out.println("error");
            }
        }


        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request,response);
    }
}
