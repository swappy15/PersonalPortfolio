package com.dao;

public interface InsertDao {

	public String saveMessage(String name,String email,String message,String date);
	public String saveEdu(String year,String title,String subtitle,String description);
	public String saveProject(String filename,String date);
	public String saveResume(String filename,String date);



	
}
