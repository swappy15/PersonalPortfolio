<%
String userid=(String)session.getAttribute("check");
if(userid!=null)
{
%>

<%@page import="com.pojo.ProjectPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

       <%!
       
       ReadDaoImp r;
       ArrayList<ProjectPojo> al1;
       
       %>
       
       <%
            r=new ReadDaoImp();
           al1= r.readProject();
           for(ProjectPojo p: al1)
           {
        %>
             <img style="height: 180px; width: 250px;" src="images/myprojects/<%=p.getFilename()%>" alt="project image">
             <form action="AddProject" method="post">
               <input type="hidden" name="sn" value="<%=p.getSn()%>">
               <input type="hidden" name="filename" value="<%=p.getFilename()%>">
               <input type="hidden" name="check" value="deleteproject">
               <button>Delete Project</button>
             </form>
             <br><br><br>
        <%} %>

</body>
</html>

<%}
else
{
	response.sendRedirect("adminauth.jsp");
}
%>