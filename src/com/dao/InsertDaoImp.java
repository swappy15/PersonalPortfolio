package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDaoImp implements InsertDao{

	private String result;
	private Connection con;
	private PreparedStatement ps;
	private String sql;
	private int i;
	@Override
	public String saveMessage(String name, String email, String message, String date) {
		
		try 
		{
			this.sql="insert into myproject.message(name,email,message,date) values(?,?,?,?)";
			this.con = ConnectionFactory.getCon();
			this.ps=this.con.prepareStatement(this.sql);
			this.ps.setString(1, name);
			this.ps.setString(2, email);
			this.ps.setString(3, message);
			this.ps.setString(4, date);
			
			this.i=this.ps.executeUpdate();
			if(this.i==1)
				this.result="inserted";
			
		} 
		catch (Exception e) 
		{
			System.out.println("saveMessage"+e);
			this.result="failed";
		}
		finally {
			return this.result;
		}
		
		
	}
	@Override
	public String saveEdu(String year, String title, String subtitle, String description) {
		try 
		{
			this.sql="insert into myproject.edu(year,title,subtitle,description) values(?,?,?,?)";
			this.con = ConnectionFactory.getCon();
			this.ps=this.con.prepareStatement(this.sql);
			this.ps.setString(1, year);
			this.ps.setString(2, title);
			this.ps.setString(3, subtitle);
			this.ps.setString(4, description);
			
			this.i=this.ps.executeUpdate();
			if(this.i==1)
				this.result="inserted";
			
		} 
		catch (Exception e) 
		{
			System.out.println("saveEdu"+e);
			this.result="failed";
		}
		finally {
			return this.result;
		}
	}
	@Override
	public String saveProject(String filename,String date) {
		try 
		{
			this.sql="insert into myproject.project(filename,date) values(?,?)";
			this.con = ConnectionFactory.getCon();
			this.ps=this.con.prepareStatement(this.sql);
			this.ps.setString(1, filename);
			this.ps.setString(2, date);
			
			this.i=this.ps.executeUpdate();
			if(this.i==1)
				this.result="inserted";
			
		} 
		catch (Exception e) 
		{
			System.out.println("saveEdu"+e);
			this.result="failed";
		}
		finally {
			return this.result;
		}
	}
	@Override
	public String saveResume(String filename, String date) {
		try 
		{
			this.sql="insert into myproject.resume(filename,date) values(?,?)";
			this.con = ConnectionFactory.getCon();
			this.ps=this.con.prepareStatement(this.sql);
			this.ps.setString(1, filename);
			this.ps.setString(2, date);
			
			this.i=this.ps.executeUpdate();
			if(this.i==1)
				this.result="inserted";
			
		} 
		catch (Exception e) 
		{
			System.out.println("saveResume"+e);
			this.result="failed";
		}
		finally {
			return this.result;
		}
	}
	
	

}
