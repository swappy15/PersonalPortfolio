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

<h3> <%@include file="messagebox/message.jsp" %> </h3>

	<%!ReadDaoImp readimp;
	ArrayList<EducationPojo> al;
	%>
	
	<%
		ReadDaoImp readimp;
		ArrayList<EducationPojo> al;
	%>
	<%
		readimp = new ReadDaoImp();
		al = readimp.readEdu();
		for (EducationPojo ep : al) {
	%>

        SN:  <%=ep.getSn()%><br>
	    YEAR:  <%=ep.getYear()%><br>
	    Title: <%=ep.getTitle()%><br>
	    Subtitle: <%=ep.getSubtitle()%><br>
	    Description: <%=ep.getDescription()%><br><br>
	    
	    <!-- Here we not sending data from jsp to Servlet but we will send Data from jsp to another jsp
	     Approach:
	     we can make update form here also
	     we can also send all the data in the form of hidden value
	     we can make set data in 5 key through session and get on updateEdu
	     we can make on send all data in one string and then we can split on updateEdu
	     we can send sn and get data from database
	     -->
	    
	    <form action="updateEdu.jsp" method="post">
	    <input type="hidden" name="sn" value="<%=ep.getSn()%>">
	    <button>update</button>
	    </form><br>
	    
	    <form action="AddEdu" method="post">
	    <input type="hidden" name="sn" value="<%=ep.getSn()%>">
	    <button>delete</button>
	    </form>
	    
	    <br><br>
	

	<%
		}
	%>

</body>
</html>
<%
	} else {
		response.sendRedirect("adminauth.jsp");
	}
%>