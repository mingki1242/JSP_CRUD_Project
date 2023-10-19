<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo.week3.MemberVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>회원정보</title>
</head>
<body>
    <div align="center">
        <h2>전체 회원 리스트</h2>
        <hr>
        <a href = "/member/insertReq.do">회원 등록</a> <br>


            <table border="1">
                <tr>
                    <th>아이디</th> <th>이름</th> <th>비밀번호</th> <th>이메일</th> <th>가입일</th>
                </tr>
<%--                <c:forEach var = "member" items="${memberList}">--%>

<%--                    <tr>--%>
<%--                        <td>${member.id}</td>--%>
<%--                        <td>${member.name}</td>--%>
<%--                        <td>${member.password}</td>--%>
<%--                        <td>${member.email}</td>--%>
<%--                        <td>${member.regdate}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
                <%
                    request.setCharacterEncoding("utf-8");
                    @SuppressWarnings("unchecked")
                    List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
                    for (MemberVO member : memberList) {
                %>
                <tr>
                    <a href = "/member/updateReq.do?id=<%=member.getId()%>"> <td><%=member.getName() %> </td>
                    <td><%=member.getPassword() %> </td> <td><%=member.getEmail() %> </td>
                    <td><%=member.getRegdate() %></td>
                </tr>
                <% } %>
        </table>
    </div>
</body>
</html>
