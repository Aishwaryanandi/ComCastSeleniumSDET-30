package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Dataverifivation 
{
	@Test
	public void sampleExecuteQueryverification() throws Throwable
	{
		String expdata = "girish";
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery(" select * from student_details;");
		while(result.next())
		{
			String actdata = result.getString(1);
			if(expdata.equalsIgnoreCase(actdata))
			{
				System.out.println("data is verified");
			}
		}
		conn.close();
		
	}

}