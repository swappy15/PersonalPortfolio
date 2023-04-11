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

Restrictions: 
1.format should be pdf
2.size should be less than 500kb

<form action="UploadResume" method="post" enctype="multipart/form-data">
  <input type="file" name="file"><br>
  <button>upload</button>
</form>

</body>
</html>

<%}
else
{
	response.sendRedirect("adminauth.jsp");
}
%>