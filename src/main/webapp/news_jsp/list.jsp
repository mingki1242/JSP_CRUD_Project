<%@ page import="com.example.demo.news.NewsVO" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뉴스피드</title>
</head>
<body>
<div align="center">
    <h2>뉴스 게시판</h2>
    <hr>
    <table border = "1">
        <tr>
            <th>제목</th> <th>기자</th> <th>등록일</th> <th>조회수</th>
        </tr>
        <%
            request.setCharacterEncoding("utf-8");
            @SuppressWarnings("unchecked")
            List<NewsVO> newslist = (List<NewsVO>) request.getAttribute("newslist");
            for(NewsVO news : newslist) {
        %>
        <tr>
            <td><a href = "news/read.do?id=<%=news.getId()%>"> <%=news.getTitle()%></a></td> <td><%=news.getWriter()%></td> <td><%=news.getRegdate()%></td> <td><%=news.getReadcnt()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
