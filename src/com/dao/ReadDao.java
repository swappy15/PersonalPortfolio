package com.dao;

import java.util.ArrayList;

import com.pojo.EducationPojo;
import com.pojo.MessagePojo;
import com.pojo.ProjectPojo;

public interface ReadDao {//Immutable
	
	public ArrayList<MessagePojo> readMessage();
	public String login(String userid,String password);
	public String checkPass(String userid,String oldpass);
	public ArrayList<EducationPojo> readEdu();
	public ArrayList<EducationPojo> readSpecificEdu(String sn);
	public ArrayList<ProjectPojo> readProject();




}
