<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
CHANGE PASS
<h3> <%@include file="messagebox/message.jsp" %> </h3>

<%!String userid; %>
<% userid=(String)session.getAttribute("check");  %>

<form action="Login" method="post">
<input type="hidden" value="<%=userid %>" name="userid" ><br>
<input type="text"  name="oldpass" placeholder="enter old pass"><br>
<input type="text" name="newpass" placeholder="enter new pass"><br>
<input type="text" name="confirmpass" placeholder="enter confirm pass"><br>
<input type="hidden" name="check" value="changepass"><br>
<button>change</button>
</form>

<br>

<a href="admin.jsp">ADMIN-HOME</a>


</body>
</html>