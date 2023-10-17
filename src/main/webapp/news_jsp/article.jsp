<%@ page import="com.example.demo.news.NewsVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뉴스 게시글 상세보기</title>
</head>
<body>
    <h2><% request.setCharacterEncoding("utf-8");
        NewsVO currentNews = (NewsVO) request.getAttribute("article");
        out.print(currentNews.getTitle());
    %></h2>

<hr>

기자 : <%= currentNews.getWriter()%> <br>
기사 내용 : <br> <%=currentNews.getBody()%> <br>
<a href = "/news/update.do?id=<%=currentNews.getId()%>">[기사 수정]</a>
<a href = "/news">[목록 보기]</a>

</body>
</html>
