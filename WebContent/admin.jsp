<%
String userid=(String)session.getAttribute("check");
if(userid!=null)
{
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="readallmessages.jsp">read All messages</a>
<br><br>

<form action="Login" method="post">
<input type="hidden" name="check" value="logout">
<button>LOGOUT</button>
</form>

<br><br>
<a href="change.jsp">Change Credentials</a><br>
<a href="addedu.jsp">Add Education</a><br>
<a href="readedu.jsp">Read All Education</a><br>
<a href="addproject.jsp">Add Project</a><br>
<a href="readproject.jsp">Read Project</a><br>
<a href="uploadresume.jsp">Upload Resume</a><br>

<%}
else
{
	response.sendRedirect("adminauth.jsp");
}
%>

</body>
</html>