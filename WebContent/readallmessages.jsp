<%
String userid=(String)session.getAttribute("check");
if(userid!=null)
{
%>
<%@page import="com.pojo.MessagePojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h3> <%@include file="messagebox/message.jsp" %> </h3>

<% 

   ReadDaoImp r= new ReadDaoImp(); 
   ArrayList<MessagePojo> al= r.readMessage();
   for(MessagePojo m:al)
   {
    
%>

<h4>Name :<%=m.getName()%> </h4>
<h4>EMAIL :<%=m.getEmail()%></h4>
<h4>MESSAGE<%=m.getMessage()%> : </h4>
<h4>DATE :<%=m.getData()%> </h4>

<form action="DeleteMessage" method="post">
<input type="hidden" name="sn" value="<%=m.getSn()%>">
<button>delete</button>
</form>

<br><br>
  <%} %>

<%}
else
{
	response.sendRedirect("adminauth.jsp");
}
%>


<a href="admin.jsp">ADMIN-HOME</a>




</body>
</html>