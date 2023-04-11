package com.controller;
import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.DeleteDaoImp;
import com.dao.InsertDaoImp;

@MultipartConfig //to handle file type data
public class AddProject extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		if(check==null)
		{
		
		Part part = request.getPart("file");
		String filename = part.getSubmittedFileName();
		
		//DAO
		String date=LocalDate.now().toString();
		String res = new InsertDaoImp().saveProject(filename, date);
		
		if(res.equals("inserted"))
		{
			//FileIO   
			InputStream i = part.getInputStream();
			byte[] b = i.readAllBytes();
		    String path="C:\\Users\\HP\\Desktop\\myproject\\WebContent\\images\\myprojects"+filename;
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			
			i.close();
			fos.close();
			
			session.setAttribute("msg", "project added successfully");
			response.sendRedirect("addproject.jsp");
		
		}    
		else
		{  
			session.setAttribute("msg", "something went wrong");
			response.sendRedirect("addproject.jsp");
		}
		
		}
		else if(check.equals("deleteproject"))
		{
			String sn = request.getParameter("sn");
			String filename = request.getParameter("filename");
			
			//dao
			String res = new DeleteDaoImp().deleteProject(sn);
			System.out.println(res);
			if(res.equals("deleted"))
			{
			  //  String path="C:\\Users\\ADMIN\\Desktop\\seed\\adv-java-nov\\workspace\\myproject\\myproject\\myproject\\WebContent\\images\\myprojects\\"+filename;
			   
			  String path=request.getRealPath("images/myprojects")+File.separator+filename;
				
				System.out.println(path);
				File file = new File(path);
				file.delete();
				
				
				session.setAttribute("msg", "project deleted successfully");
				response.sendRedirect("readproject.jsp");
			}
			else         
			{
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("readproject.jsp");
			}

		}
		
		
	}
}
