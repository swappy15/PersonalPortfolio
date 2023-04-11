package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImp;

public class DeleteMessage extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sn = request.getParameter("sn");
		HttpSession session = request.getSession();
		//dao     
		String res = new DeleteDaoImp().deleteMessage(sn);
		if(res.equals("deleted"))
		{
			session.setAttribute("msg", "msg deleted successfully");
			response.sendRedirect("readallmessages.jsp");
		}
		else   
		{
			session.setAttribute("msg", "something went wrong");
			response.sendRedirect("readallmessages.jsp");
		}     
	}

}
