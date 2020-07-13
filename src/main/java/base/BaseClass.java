package base;


import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.events.api.Listener;

public class BaseClass {
	
	public static AndroidDriver<AndroidElement> driver;
	public static boolean resetApp = true;
	
	@BeforeTest
	public void setup() {
	
		try {
			
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\base\\global.properties");
			
			Properties properties = new Properties();
			properties.load(fileInputStream);
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,   properties.get("DeviceName"));
			capabilities.setCapability(MobileCapabilityType.VERSION,       properties.get("OSVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.get("platformName"));
			capabilities.setCapability("appPackage",  properties.get("AppPackage"));
			capabilities.setCapability("appActivity", properties.get("AppActivity"));
			
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ElementListener());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterMethod
	public void resetApp() {
		if(resetApp == true) {
			driver.resetApp();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
