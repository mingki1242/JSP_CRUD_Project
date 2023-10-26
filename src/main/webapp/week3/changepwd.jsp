<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>암호 변경</title>
</head>
<body>
    <div align="center">
        <form action = "/login/changepwd.do" method="post">
            현재 비밀번호 : <input type = "text" name = "current_pass"> <br> <c:if test = "${errors.currentpass}">현재 비밀번호를 입력하시오</c:if>
            바꿀 비밀번호 : <input type = "text" name = "changefin_pass"> <br> <c:if test = "${errors.changefinpass}">바꿀 비밀번호를 입력하시오</c:if>
            <input type = submit value="변경">
            <c:if test = "${errors.notMatch}">비밀번호가 일치 하지 않습니다</c:if>
        </form>
    </div>
</body>
</html>
