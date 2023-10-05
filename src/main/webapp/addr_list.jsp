<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.week2.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dao" class = "com.example.demo.week2.ContactDAO" scope="application"/>

<html>
<head>
    <title>주소록</title>
</head>

<div align="center">
  <h2>주소록</h2>
  <hr>
  <a href = "addr_form.html">주소 추가</a>
  <table border = "1">
    <tr>
      <th>이름</th>
      <th>전화번호</th>
      <th>이메일</th>
      <th>성별</th>
    </tr>
    <%
      ArrayList<Contact> clist = dao.getList();
      for(Contact item : clist) {
    %>

    <tr>
      <td><%=item.getName()%></td>
      <td><%=item.getEmail_Address()%></td>
      <td><%=item.getPhone_Num()%></td>
      <td><%=item.getGender()%></td>
    </tr>
    <%
    }
    %>
  </table>

</div>

</body>

</html>
