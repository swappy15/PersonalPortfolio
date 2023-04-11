package com.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.jni.FileInfo;

import com.dao.InsertDaoImp;
import com.validation.Validate;
   
@MultipartConfig
public class UploadResume extends HttpServlet {
	
	private String path="C:\\Users\\HP\\Desktop\\myproject\\WebContent\\images\\resume\\";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String check = request.getParameter("check");
		if(check==null)
		{
		
	   Part part = request.getPart("file");  
	   String filename = part.getSubmittedFileName();
	  
	   HttpSession session = request.getSession();
	   //validate
	   String res = new Validate().validateResume(part);
	   
	   if(res.equals("valid"))
	   {
		   //dao
		    res=new InsertDaoImp().saveResume(filename,LocalDate.now().toString());
		    if(res.equals("inserted"))
		    {
		    	
		    	//file io
		    	path="C:\\Users\\HP\\Desktop\\myproject\\WebContent\\images\\resume\\"+filename;
		    	InputStream i = part.getInputStream();
		    	byte[] b = i.readAllBytes();
		    	
		    	FileOutputStream fos = new FileOutputStream(path);
		    	fos.write(b);
		    	i.close();
		    	fos.close();
		    	
		    	 session.setAttribute("msg", "Resume uploaded successfully");
				 response.sendRedirect("uploadresume.jsp");
		    }
		    else
		    {
		         session.setAttribute("msg", "something went wrong");
				 response.sendRedirect("uploadresume.jsp");
		    }
	   }
	   else
	   {
		   session.setAttribute("msg", res);
		   response.sendRedirect("uploadresume.jsp");
	   }
	   
	   }
	   else if(check.equals("download"))
	   {
            FileInputStream fis = new FileInputStream(path);
            byte[] b = fis.readAllBytes();
            
            ServletOutputStream os = response.getOutputStream();
            response.setHeader("content-disposition", "filename=swapnilresume.pdf");
            response.setContentType("application/octet-stream");//octet-stream ->unknown file
            
            os.write(b);
            fis.close();
            os.close();
            
	   }
	}
}
