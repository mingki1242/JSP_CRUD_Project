<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산</title>
</head>
<body>
<div align="center">
  <h2>계산</h2>
  <%=session.getAttribute("login")%>님이 선택한 상품 목록
  <hr>
  <%
    PrintWriter out1 = response.getWriter();
    ArrayList<String> plist = (ArrayList<String>)session.getAttribute("plist");
    for(String item : plist)
    {
      out1.println(item + "<br>");
    }
  %>
</div>
</body>
</html>
