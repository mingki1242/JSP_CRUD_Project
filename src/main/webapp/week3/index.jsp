<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <c:if test = "${!empty userAuth}">
        <h2>${userAuth.name}님 환영합니다</h2>
        <a href = "/login/logout.do">[로그아웃]</a>
        <a href = "/login/changepwd.do">[암호변경]</a>
    </c:if>
    <c:if test = "${empty userAuth}">
        <a href = "/member/insert.do">[회원가입]</a>
        <a href = "/login/login.do">[로그인]</a>
    </c:if>

</div>
</body>
</html>
