<%--
  Created by IntelliJ IDEA.
  User: qkral
  Date: 2023-10-05
  Time: 오후 6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
  String username = request.getParameter("Login");
  if(username != null)
    session.setAttribute("login" , username); //세션에 정보를 등록
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div align="center">
    <h2>상품 선택</h2>
    <hr>
    <%= session.getAttribute("login")%>님 환영합니다
    <form action = "add.jsp" method="post">
      <select name = "product">
        <option value = "사과">사과</option>
        <option value = "옥수수">옥수수</option>
        <option value = "수박">수박</option>
        <option value = "최현수">최현수 </option>
        <option value= "김치찌개">김치찌개</option>
      </select>
      <input type="submit" value="추가">
    </form>
    <a href="checkout.jsp">계산</a>
  </div>
</body>
</html>
