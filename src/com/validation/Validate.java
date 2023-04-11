package com.validation;

import javax.servlet.http.Part;

public class Validate {
    private String result;
	public String validateResume(Part part) {
		// TODO Auto-generated method stub
		
		String type = part.getContentType();
		long size = part.getSize();
		System.out.println(size);
		System.out.println(type);
		
		if(!type.endsWith("pdf"))
		{
			result="invalid file format";
		}
		else if(size>5120000)
		{
			result="file size exceeded";
		}
		else
		{
			result="valid";
		}
		
		return result;
		
	}

}
