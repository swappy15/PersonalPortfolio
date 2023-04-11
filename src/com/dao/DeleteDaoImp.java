package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDaoImp implements DeleteDao {

	private String result;
	private Connection con;
	private PreparedStatement ps;
	private String sql;
	private int i;
	@Override
	public String deleteMessage(String sn) {
		
		try {
			con = ConnectionFactory.getCon();
			sql = "delete from myproject.message where sn=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(sn));
			i=ps.executeUpdate();
			if(i==1)result="deleted";

		} catch (Exception e) {
			System.out.println(e);
			result="failed";
		}
		finally {
			return result;
		}
	}
	@Override
	public String deleteEdu(String sn) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteProject(String sn) {
		try {
			con = ConnectionFactory.getCon();
			sql = "delete from myproject.project where sn=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(sn));
			i=ps.executeUpdate();
			if(i==1)result="deleted";

		} catch (Exception e) {
			System.out.println(e);
			result="failed";
		}
		finally {
			return result;
		}
	}

}
