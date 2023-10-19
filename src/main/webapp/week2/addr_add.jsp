<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="Contact" class="com.example.demo.week2.Contact" scope = "request"></jsp:useBean>
<jsp:setProperty name="contact" property="*"></jsp:setProperty>
<jsp:useBean id="dao" class="com.example.demo.week2.ContactDAO" scope = "application"></jsp:useBean>
<%dao.add(Contact);%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>등록내용</h2>
  이름 : <%=Contact.getName()%> <br>
  전화번호 : <%=Contact.getPhone_Num()%> <br>
  이메일 : <%=Contact.getEmail_Address()%> <br>
  성별 : <%=Contact.getGender()%> <br>
  <hr>
  <a href = "addr_list.jsp">목록 보기</a>
</body>
</html>
