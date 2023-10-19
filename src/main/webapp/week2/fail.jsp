<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>성적 취득 실패</title>
</head>
<body>
<h2>총점이 60점 미만입니다</h2><p>
  학번 : <%=request.getParameter("id")%><br>
  이름 : <%=request.getParameter("name")%><br>
  중간시험 : <%=request.getParameter("middle")%><br>
  기말기험 : <%=request.getParameter("final")%><br>
  레포트 : <%=request.getParameter("report")%><br>
  출석 : <%=request.getParameter("attendance")%><br>

  총점 : <%=request.getParameter("total")%><br>
</p>
</body>
</html>
