package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDaoImp implements UpdateDao {

	private String result;
	private Connection con;
	private PreparedStatement ps;
	private String sql;
	private int i;
	@Override
	public String changePass(String newpass, String userid) {
		
		try 
		{
			con=ConnectionFactory.getCon();
			sql="update myproject.admin set password=? where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setString(2, userid);
			
			i=ps.executeUpdate();
			if(i==1)result="updated";
			
		} 
		catch (Exception e)
		{
			System.out.println("changePass"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}
	@Override
	public String updateEdu(String sn, String year, String title, String subtitle, String description) {
		try 
		{
			con=ConnectionFactory.getCon();
			sql="update myproject.edu set year=?,title=?,subtitle=?,description=? where sn=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
			ps.setString(5, sn);

			
			i=ps.executeUpdate();
			if(i==1)result="updated";
			
		} 
		catch (Exception e)
		{
			System.out.println("changePass"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}

}
