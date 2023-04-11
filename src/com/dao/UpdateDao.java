package com.dao;

public interface UpdateDao {
	
	public String changePass(String newpass, String userid);
	public String updateEdu(String sn,String year,String title,String subtitle,String description);


}
