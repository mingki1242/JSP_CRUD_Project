<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <div align="center">

        <form action = "/login/login.do" method="post">
            <c:if test = "${errors.email}">이메일을 입력하세요 <br></c:if>
            <c:if test = "${errors.password}">비밀번호를 입력하세요 <br></c:if>
            이메일 :<br>
            <input type="text" name="email"><br>
            암호 : <br>
            <input type="text" name = "password"><br>

            <input type = "submit" value = "로그인"><br>
            <c:if test = "${errors.notMatch}">비밀번호가 일치하지 않습니다<br></c:if>
        </form>
    </div>
</body>
</html>
