<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2023-10-25
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>암호 변경</title>
</head>
<body>
    <div align="center">
        <c:if test = "${error.notmatch}">현재 비밀번호가 일치하지 않습니다</c:if>
        <c:if test = "${error.success}">성공적으로 암호가 변경되었습니다</c:if>
        <form action ="/login/changepwd.do" method="post">
            현재 암호 : <input type="text" name="cpass"><br> <c:if test = "${error.currentpwd}">현재 비밀번호를 입력하세요</c:if>
            새 암호 : <input type="text" name="npass"><br> <c:if test = "${error.newpwd}">바꿀 비밀번호를 입력하세요</c:if>
            <input type = "submit" value="암호 변경"> <br>
        </form>
    </div>
</body>
</html>
