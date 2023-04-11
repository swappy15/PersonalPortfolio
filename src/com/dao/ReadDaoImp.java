package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.EducationPojo;
import com.pojo.MessagePojo;
import com.pojo.ProjectPojo;

public class ReadDaoImp implements ReadDao{

	private String result;
	private Connection con;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;
	private ArrayList<MessagePojo> al=new ArrayList<MessagePojo>();
	private ArrayList<EducationPojo> al1=new ArrayList<EducationPojo>();
	private ArrayList<ProjectPojo> al2=new ArrayList<ProjectPojo>();


	@Override
	public ArrayList<MessagePojo> readMessage() {
		
		try 
		{
			al.clear();
			sql="select * from myproject.message";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				MessagePojo msg = new MessagePojo();
				msg.setSn(rs.getInt("sn"));
				msg.setName(rs.getString("name"));
				msg.setEmail(rs.getString("email"));
				msg.setMessage(rs.getString("message"));
				msg.setData(rs.getString("date"));
				
				al.add(msg);
			}
		} 
		catch (Exception e) {
			System.out.println("readMessage"+e);
		}
		finally {
			
			return al;
		}
		
		
	}
	@Override
	public String login(String userid, String password) {
		try 
		{
			
			sql="select * from myproject.admin where userid=? and password=?";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()==true)
			{
				result="exist";
			}
			else
			{
				result="not exist";
			}
			
		} 
		catch (Exception e) {
			System.out.println("readMessage"+e);
			result="not exist";
		}
		finally {
			
			return result;
		}
	}

	@Override
	public String checkPass(String userid, String oldpass) {
		try 
		{
			
			sql="select * from myproject.admin where userid=? and password=?";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, oldpass);
			rs = ps.executeQuery();
			if(rs.next()==true)
			{
				result="exist";
			}
			else
			{
				result="not exist";
			}
			
		} 
		catch (Exception e) {
			System.out.println("readMessage"+e);
			result="not exist";
		}
		finally {
			
			return result;
		}
	}
	@Override
	public ArrayList<EducationPojo> readEdu() {
		try 
		{
			al1.clear();
			sql="select * from myproject.edu";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				EducationPojo edu = new EducationPojo();
				edu.setSn(rs.getInt("sn"));
				edu.setYear(rs.getString("year"));
				edu.setTitle(rs.getString("title"));
				edu.setSubtitle(rs.getString("subtitle"));
				edu.setDescription(rs.getString("description"));
				
				al1.add(edu);
			}
		} 
		catch (Exception e) {
			System.out.println("readMessage"+e);
		}
		finally {
			
			return al1;
		}
		
	}
	@Override
	public ArrayList<EducationPojo> readSpecificEdu(String sn) {
		try 
		{
			al1.clear();
			sql="select * from myproject.edu where sn=?";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(sn));
			rs = ps.executeQuery();
			while(rs.next())
			{
				EducationPojo edu = new EducationPojo();
				edu.setSn(rs.getInt("sn"));
				edu.setYear(rs.getString("year"));
				edu.setTitle(rs.getString("title"));
				edu.setSubtitle(rs.getString("subtitle"));
				edu.setDescription(rs.getString("description"));
				
				al1.add(edu);
			}
		} 
		catch (Exception e) {
			System.out.println("readMessage"+e);
		}
		finally {
			
			return al1;
		}
	}
	@Override
	public ArrayList<ProjectPojo> readProject() {
		try 
		{
			al2.clear();
			sql="select * from myproject.project";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				ProjectPojo p = new ProjectPojo();
				p.setSn(rs.getInt("sn")); 
				p.setFilename(rs.getString("filename"));
				p.setDate(rs.getString("date"));
				al2.add(p);
			}
		} 
		catch (Exception e) {
			System.out.println("readMessage"+e);
		}
		finally {
			
			return al2;
		}
	}
}
