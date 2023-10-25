<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 화면</title>
</head>
<body>
<div align="center">
    <c:if test = "${errors.notMatch}">
        아이디와 비밀번호가 일치하지 않습니다
    </c:if>
    <form action = "/login/login.do" method="post">
        이메일 : <input type="text" name = "email"> <br> <c:if test = "${errors.email}">이메일을 입력하세요</c:if>
        비밀 번호 : <input type = "text" name = "password"> <br> <c:if test = "${errors.password}">비밀번호를 입력하세요</c:if>
        <input type = "submit" value = "로그인"> <br>
    </form>
</div>
</body>
</html>
