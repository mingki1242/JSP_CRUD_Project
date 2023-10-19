
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 등록</title>
</head>

<body>
<div align="center">
    <h2>회원 등록</h2>
    <hr>
    <form action = "/member/insert.do" method="post">
    <table>
        <tr>
            <th>이름</th>
            <td><input type="text" name = "name"></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name = "password"></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="text" name = "email"></td>
        </tr>
        <tr>
            <th>가입일</th>
            <td><input type="text" name = "reqdate"></td>
        </tr>
        <tr>
            <td><input type="submit" value = "등록">
            <td><input type = "reset" value = "취소">
        </tr>
    </table>
    </form>
</div>
</body>
</html>
