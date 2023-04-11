package com.autocreation;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.dao.ConnectionFactory;

public class AutoCreate implements ServletContextListener {

    private String sql;
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	try 
    	{
			sql = "drop database myproject1";
			Connection con = ConnectionFactory.getCon();
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	try { 
    		sql="create database myproject1";
			Connection con = ConnectionFactory.getCon();
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} 
    	catch (Exception e) {
			System.out.println("datacreation"+e);
		}
    	finally {
    		try   { 
        		sql="create table myproject1.admin(sn int primary key,userid varchar(30),password varchar(30))";
    			Connection con = ConnectionFactory.getCon();
    			Statement st = con.createStatement();
    			st.executeUpdate(sql);
    		} 
        	catch (Exception e) {
    			System.out.println("datacreation"+e);
    		}
    	  }
       }
}
