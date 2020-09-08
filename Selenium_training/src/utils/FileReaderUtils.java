package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderUtils {

	public static void main(String[] args) 
	{
		System.out.println(getPropertyValue("username"));
	}
	public static String getPropertyValue(String key) {
		System.out.println("Reading Properties file , getting value for " + key);
		File f = null;
		FileInputStream fis = null;
		Properties props = null;
		String value =null;
		try
		{
			f = new File("data\\globaldata.properties");
			fis = new FileInputStream(f);
			props = new Properties();
			props.load(fis);
			value = (props.getProperty(key)!=null?props.getProperty(key):"no key found");
			System.out.print(" and the value is " + value + "\n");
		}
		catch(FileNotFoundException ex )
		{
			System.out.println("File not found");
		}
		catch (IOException e) {
			System.out.println("IO Exception");
		}
		finally {
			try
			{
				fis.close();
			}
			catch(Exception ex)
			{
				System.out.println("Error while closing the file input stream");
			}
		}
		return value;
	}
	
	
		}

