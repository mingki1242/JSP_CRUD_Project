<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.util.ArrayList "%>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<String> plist = (ArrayList<String>)session.getAttribute("plist");

  //장바구니 리스트가 널이면 새로운 세션을 추가
  if(plist ==null)
  {
    plist = new ArrayList<>();
    session.setAttribute("plist" , plist);
  }

  String product = request.getParameter("product");
  plist.add(product);

%>

<script>
  alert("추가된 상품은 <%=product%> 입니다")
  history.go(-1)
</script>