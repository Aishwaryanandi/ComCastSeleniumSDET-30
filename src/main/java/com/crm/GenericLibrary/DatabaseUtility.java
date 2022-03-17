package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this method contains generic methods to read data from database
 * @author owner
 *
 */

public class DatabaseUtility
{
	Connection con=null;
	
	public void connectToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbusername, IPathConstants.dbpassword);
	}
	/**
	 * this method will close the connection
	 * @throws Throwable
	 */
	public void closeconnection() throws Throwable
	{
		con.close();
	}
	/**
	 * this method will execute the query and return the matching data to the user 
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return 
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		String data=null;
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String data1 = result.getString(columnIndex);
			if(data1.equalsIgnoreCase(expData))
			{
				flag=true; //flag raising
				break;
			}
			if(flag)
			{
				System.out.println(data1+"----->data verified");
				
			}
			

			else
			{
				System.out.println("data not verified");
				return "";
				
			}
		}
		return expData;
	}
	public int  executeUpdateQuery(String query) throws Throwable
	{
		int res = con.createStatement().executeUpdate(query);
		return res;
	}

}
