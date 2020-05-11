package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestUtility {

	AndroidDriver<AndroidElement> driver;
	
	public TestUtility(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
}
