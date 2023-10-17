<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    int total = Integer.parseInt(request.getParameter("middle"))+
            Integer.parseInt(request.getParameter("final"))+
            Integer.parseInt(request.getParameter("report"))+
            Integer.parseInt(request.getParameter("attendance"));

    String next_page = (total > 60) ? "success.jsp" : "fail.jsp";
%>

<jsp:forward page="<%=next_page%>">
    <jsp:param value="<%=total%>" name="total"/>
</jsp:forward>