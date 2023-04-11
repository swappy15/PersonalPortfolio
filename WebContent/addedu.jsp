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
<form action="AddEdu" method="post">
<input name="year" type="text" placeholder="enter year"><br>
<input name="title" type="text" placeholder="enter title"><br>
<input name="subtitle" type="text" placeholder="enter subtitle"><br>
<input name="description" type="text" placeholder="enter description"><br>
<button>Add</button>
</form>

</body>
</html>

<%}
else
{
	response.sendRedirect("adminauth.jsp");
}
%>