<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 대기 화면</title>
</head>
<body>
<div align="center">
    <c:if test = "${empty authUser}">
        <a href = "/member/insertReq.do">[회원 가입]</a>
        <a href = "/login/login.do">[로그인]</a>
    </c:if>
    <c:if test = "${!empty authUser}">
        <h2>${authUser.name} 님 반갑습니다</h2>
        <a href = "/login/logout.do">[로그 아웃]</a>
        <a href = "/login/changepwd.do">[암호 변경]</a>
    </c:if>
</div>
</body>
</html>
