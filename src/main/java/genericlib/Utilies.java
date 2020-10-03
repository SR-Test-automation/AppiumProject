package genericlib;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Utilies {
	
	public static void longpress(PerformsTouchActions driver,WebElement element)
	{
		TouchAction t=new TouchAction(driver);
		t.longPress(LongPressOptions.longPressOptions()
		.withElement(ElementOption.element(element)))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.release().perform();
	}
	
	public static void tap(PerformsTouchActions driver,WebElement element)
	{
		TouchAction t=new TouchAction(driver);
		t.tap(TapOptions.tapOptions()
	    .withElement(ElementOption.element(element)))
		.perform();
		
	}
	public static void swipeVerticallyButtomTop(WebDriver driver,PerformsTouchActions driver1)
	{
		Dimension s = driver.manage().window().getSize();
		int height=s.getHeight();
		int widht=s.getWidth();
		
		int x=widht/2;
		int starty=(int)(height*0.8);
		int endy=(int)(height*0.2);
		
		TouchAction t=new TouchAction(driver1);
		t.press(PointOption.point(x,starty))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(x,endy))
		.release().perform();
		
	}
	
	public static void swipeVerticallyTopButtom(WebDriver driver,PerformsTouchActions driver1)
	{
		Dimension s = driver.manage().window().getSize();
		int height=s.getHeight();
		int widht=s.getWidth();
		
		int x=widht/2;
		int starty=(int)(height*0.8);
		int endy=(int)(height*0.2);
		
		TouchAction t=new TouchAction(driver1);
		t.press(PointOption.point(x,endy))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(x,starty))
		.release().perform();
		
	}
	public static void swipeHorizontallyLefttoRight(WebDriver driver,PerformsTouchActions driver1)
	{
		Dimension s = driver.manage().window().getSize();
		int height=s.getHeight();
		int widht=s.getWidth();
		
		int y=height/2;
		int startx=(int)(widht*0.8);
		int endx=(int)(widht*0.2);
		
		TouchAction t=new TouchAction(driver1);
		t.press(PointOption.point(y,startx))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(y,endx))
		.release().perform();
		
	}
	
	public static void swipeHorizontallyRighttoLeft(WebDriver driver,PerformsTouchActions driver1)
	{
		Dimension s = driver.manage().window().getSize();
		int height=s.getHeight();
		int widht=s.getWidth();
		
		int y=height/2;
		int startx=(int)(widht*0.8);
		int endx=(int)(widht*0.2);
		
		TouchAction t=new TouchAction(driver1);
		t.press(PointOption.point(y,endx))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(y,startx))
		.release().perform();
		
	}
	
	public static void swipeParticularEement(AndroidDriver<WebElement> driver,String ele,String loc)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(loc(\"ele\")");
	}

}
