<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <%@include file="messagebox/message.jsp" %>
   
   <form action="Login" method="post">
     <input type="text" name="userid" placeholder="Enter USERID"><br>
     <input type="password" name="password" placeholder="Enter PASS"><br>
     <button>LOGIN</button>
   </form>

</body>
</html>