package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	static AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() {
	
		try {
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 29 (Emulator)");
			capabilities.setCapability(MobileCapabilityType.VERSION, "10.0");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			
			capabilities.setCapability("appPackage", "de.wetteronline.wetterapp");
			capabilities.setCapability("appActivity", "de.wetteronline.wetterapp.MainActivityGoogle");
			
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterMethod
	public void resetApp() {
		driver.resetApp();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
