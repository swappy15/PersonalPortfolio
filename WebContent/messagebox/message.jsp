<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%-- <% 
  
  String msg=(String)session.getAttribute("msg");
  if(msg!=null)
  {
  %>
  <h2><%=msg%></h2>
 
 <%} --%>
 
  
  ${sessionScope.msg}
  <% 
  session.removeAttribute("msg");
  %>
   
 
</body>
</html>