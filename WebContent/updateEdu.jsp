<%@page import="com.pojo.EducationPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<%
	String userid = (String) session.getAttribute("check");
	if (userid != null) {
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

        <%!  
        String sn;
        ReadDaoImp read;
        ArrayList<EducationPojo> al;
        
        %>
        
        <%
            sn= request.getParameter("sn");
            read=new ReadDaoImp();
            al=read.readSpecificEdu(sn);
            EducationPojo ep=al.get(0);
        %>

        <form action="AddEdu" method="post">
		    <input type="text" name="year" value="<%=ep.getYear()%>"><br>
		    <input type="text" name="title" value="<%=ep.getTitle()%>"><br>
		    <input type="text" name="subtitle" value="<%=ep.getSubtitle()%>"><br>
		    <input type="text" name="description" value="<%=ep.getDescription()%>"><br>
		    <input type="hidden" name="check" value="update"><br>
		    <input type="hidden" name="sn" value="<%=ep.getSn()%>"><br>
		    <button>update</button>
	    </form><br>

</body>
</html>
<%
	} else {
		response.sendRedirect("adminauth.jsp");
	}
%>