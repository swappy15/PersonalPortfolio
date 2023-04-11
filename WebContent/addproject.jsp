<%
String userid=(String)session.getAttribute("check");
if(userid!=null)
{
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> <%@include file="messagebox/message.jsp" %> </h3>

    <form action="AddProject" method="post" enctype="multipart/form-data">
      <input type="file" name="file" required="required"><br>
      <button>add</button>
    </form>

</body>
</html>

<%}
else
{
	response.sendRedirect("adminauth.jsp");
}
%>