<%@ page import="com.example.demo.news.NewsVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>기사 수정 폼</title>
</head>
<body>
    <h2>기사 수정</h2>
<hr>
    <% request.setCharacterEncoding("utf-8");
        NewsVO currentNews = (NewsVO) request.getAttribute("article");
    %>
<form method="post" action = "update.fin">
    <input type="hidden" name="id" value="<%=currentNews.getId()%>">
    기자 : <input type = "text" name = "writer" value = <%=currentNews.getWriter()%>> <br>
    제목 : <input type = "text" name = "title" value = "<%= currentNews.getTitle()%>"> <br>
    내용 : <textarea name="body" rows="5" cols="40"><%=currentNews.getBody()%></textarea> <br>
    <input type = "submit" value="수정">
    <a href="/news">취소</a>
</form>
</body>
</html>
