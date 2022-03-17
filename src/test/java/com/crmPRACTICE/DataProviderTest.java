package com.crmPRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest
{
	@Test(dataProvider="getData")
	 public void sampleDataProvider(String Name, String model){
	 
		System.out.println(Name+"---"+model+"---");
		
	 }
	
	@DataProvider
	public Object[][]getData()
	{
		Object[][] obj=new Object[6][2];
		
		obj[0][0]="ViVo";
		obj[0][1]="ViVo V15 Pro";
	
		
		obj[1][0]="Mi";
		obj[1][1]="13 Pro max";
		
		
		obj[2][0]="iPhone";
		obj[2][1]="11 max";
		
		
		obj[3][0]="Samsung";
		obj[3][1]="A80";

		
		obj[4][0]="Oppo";
		obj[4][1]="Oppo V12 Pro";
	
		
		obj[5][0]="Nokia";
		obj[5][1]="1100";

		
		return obj;
		
	}
	

}
