package com.controller;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertDaoImp;

public class SaveMessage extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String date=LocalDate.now().toString();
		//validate data
		
		//dao
		String res = new InsertDaoImp().saveMessage(name, email, message, date);
		HttpSession session = request.getSession();
		if(res.equals("inserted"))
		{
			session.setAttribute("msg", "MSG SENT SUCCESSFULLY");
			response.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG");
			response.sendRedirect("index.jsp");
		}
	}

}
