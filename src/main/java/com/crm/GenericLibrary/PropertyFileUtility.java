package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author owner
 *
 */

public class PropertyFileUtility
{
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
}
}
