package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author owner
 *
 */
public class JavaUtility
{
	/**
	 * this method will generate a random number and return it to user
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int rand = ran.nextInt(500);
		return rand;
	}
	/**
	 * this method will generate a current system date and return it to user
	 * @return
	 */
	 public String getSystemDate()
	 {
		 Date d= new Date();
		 String date = d.toString();
		 return date;
	 }
	 /**
	  * this method will
	  * @return
	  */
	 public String getSystemDateInFormat()
	 {
		 Date d=new Date();
		 String d1 = d.toString();
		 String[] date = d1.split(" ");
		 String mon = date[1];
		 String day = date[2];
		 String day1 = date[3].replace(":", "-");
		 String year = date[5];
		 String Dateformat = day+"  - "+mon+" - "+year;
		 return Dateformat;
	 }

}



