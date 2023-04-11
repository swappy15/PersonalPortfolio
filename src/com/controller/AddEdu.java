package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertDaoImp;
import com.dao.UpdateDaoImp;

public class AddEdu extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		
		if(check==null)
		{
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		//DAO
		String res = new InsertDaoImp().saveEdu(year, title, subtitle, description);
		if (res.equals("inserted")) {
			session.setAttribute("msg", "Added Successfully");
			response.sendRedirect("addedu.jsp");
		} else {
			session.setAttribute("msg", "Something went wrong");
			response.sendRedirect("addedu.jsp");
		}
		
		}
		else if(check.equals("update"))
		{
			String sn = request.getParameter("sn");
			String year = request.getParameter("year");
			String title = request.getParameter("title");
			String subtitle = request.getParameter("subtitle");
			String description = request.getParameter("description");
			
			//update dao
			String res = new UpdateDaoImp().updateEdu(sn, year, title, subtitle, description);
			 if(res.equals("updated"))
			 {
				    session.setAttribute("msg", "update successfully");
					response.sendRedirect("readedu.jsp");
			 }
			 else
			 {
			    	session.setAttribute("msg", "something went wrong");
					response.sendRedirect("readedu.jsp");
			 }
			
		}

	}

}
