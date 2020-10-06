package genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

public class Propertyfile implements AutoConstant {
	
	public static String getdata(String key1)
	{
		Properties p=new Properties();
		try {
		p.load(new FileInputStream(propertyfilepath));
		}
		catch(Exception e)
		{
			Reporter.log("data is not taken from propertyfile");
		}
		return p.getProperty(key1);
	}
	

}
