package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{

	@Test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		Connection conn=null;
		try
		{
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		 System.out.println("connection established");
		Statement state = conn.createStatement();
		//"insert into student values('2','Aishwarya','female')");
		int result = state.executeUpdate("rename table student to student_details;");
		if(result==1)
		{
			System.out.println("data added successfuly" );
			
		}
		else
		{
			System.out.println("data failed");
		}
		}
		catch(Exception e)
		{
			System.out.println("connection closed");
		}
		finally
		{
			conn.close();
		}

	
}
}