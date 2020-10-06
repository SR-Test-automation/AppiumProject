package genericlib;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest implements AutoConstant{
	AppiumDriverLocalService service=null;
	public AndroidDriver<WebElement> driver;
	@BeforeSuite
	public void startserver()
	{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}

	@BeforeMethod
	public void openapp()
	{
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME,DeviceName);
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION,PlatformVersion);
		d.setCapability(MobileCapabilityType.PLATFORM_NAME,PlatformName);
		d.setCapability(MobileCapabilityType.APP,app);
		try {
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		 driver=new AndroidDriver<WebElement>(u,d);
		}
		catch(Exception e)
		{
			Reporter.log("handled",true);
			
		}
		
	}
	
	@AfterMethod
	public void closeapplication(ITestResult r)
	{
		int status = r.getStatus();
		String name = r.getName();
		if(status==2)
		{
			Photo.getphoto(driver, name);
		}
		driver.close();
	}
	
	
	
	
	@AfterSuite
	public void closeserver()
	{
		service.stop();
	}
}
