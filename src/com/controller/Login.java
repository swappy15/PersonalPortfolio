package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ReadDaoImp;
import com.dao.UpdateDaoImp;

public class Login extends HttpServlet {
	private String res;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		if(check==null) 
		{
			   
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			
			//dao
			res = new ReadDaoImp().login(userid, password);
			  
			
			if(res.equals("exist"))
			{
				session.setAttribute("check", userid);
				response.sendRedirect("admin.jsp");
			}
			else
			{
				session.setAttribute("msg", "userid or password does not exist");
				response.sendRedirect("adminauth.jsp");
			}
		}
		else if(check.equals("logout"))
		{
			//logout logic
			session.removeAttribute("check");
			response.sendRedirect("adminauth.jsp");
			
		}else if(check.equals("changepass")) 
		{
			String userid = request.getParameter("userid");
			String oldpass = request.getParameter("oldpass");
			String newpass = request.getParameter("newpass");
			String confirmpass = request.getParameter("confirmpass");
			System.out.println(userid);
			  
			if(!newpass.equals(confirmpass) && !oldpass.equals(newpass))
			{
				session.setAttribute("msg", "please check confirm pass");
				response.sendRedirect("change.jsp");
			}
			else
			{
			    res = new ReadDaoImp().checkPass(userid, oldpass);
			    if(res.equals("exist"))
			    {
			    	//updatedao
			    	 res=new UpdateDaoImp().changePass(newpass, userid);
			    	 if(res.equals("updated"))
			    	 {
			    		session.setAttribute("msg", "updated successfully");
						response.sendRedirect("change.jsp");
			    	 }
			    	 else
			    	 {
			    		session.setAttribute("msg", "something went wrong");
						response.sendRedirect("change.jsp");
			    	 }
			    }
			    else
			    {
			    	session.setAttribute("msg", "please check old pass");
					response.sendRedirect("change.jsp");
			    }
			}
		}
	}
}
