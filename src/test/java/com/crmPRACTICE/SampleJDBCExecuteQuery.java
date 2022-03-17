package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.exec.util.DebugUtils;
import org.testng.annotations.Test;


import com.mysql.cj.jdbc.Driver;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

public class SampleJDBCExecuteQuery 
{
 
	@Test
	
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("select * from student;");
		while(result.next())
		{
			System.out.println(result.getString(1)+ " "+result.getString(2)+" "+result.getString(3));
		}
		conn.close();
			
		
		
	}
	
}
