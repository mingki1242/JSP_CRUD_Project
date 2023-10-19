<%@ page import="com.example.demo.week3.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 등록</title>
    <script>
        function deleteChecked()
        {
            result = confirm("정말 삭제 하시겠습니까?");
            if(result)
            {
                document.form1.action = "/member/delete.do";
                document.form1.submit();
            }
        }
    </script>
</head>

<body>
<div align="center">
    <h2>회원 정보 수정/삭제</h2>
    <hr>
    <%
        request.setCharacterEncoding("utf-8");
        MemberVO member = (MemberVO) request.getAttribute("member");
    %>
    <form name="form1" action = "/member/update.do" method="post">
        <input type = "hidden" name="id" value="<%=member.getId()%>">
        <table>
            <tr>
                <th>이름</th>
                <td><input type="text" name = "name" value="<%=member.getName()%>"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name = "password" value="<%=member.getPassword()%>"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name = "email" value="<%=member.getEmail()%>"></td>
            </tr>
            <tr>
                <th>가입일</th>
                <td><input type="text" name = "reqdate" value="<%=member.getRegdate()%>"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value = "수정">
                    <input type = "reset" value = "취소">
                    <input type = "button" value = "삭제" onclick="deleteChecked()">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
