package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import pages.MainPage;
import pages.MyPlacesPage;

public class MainPageExistenceTest extends BaseClass {

	private MyPlacesPage myPlaces;
	
	@BeforeClass
	public void navigateToMainPage() {
		BaseClass.resetApp = false;
		
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void checkIfHamburgerButtonExists() {
		Boolean elementExists = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Menü öffnen\"]")).size() > 0;
		Assert.assertTrue(elementExists);
	}
	
	@Test
	public void checkIfMagnifierExists() {
		Boolean elementExists = driver.findElements(By.id("de.wetteronline.wetterapp:id/action_search")).size() > 0;
		Assert.assertTrue(elementExists);
	}
	
	@Test
	public void checkIfTemperatureExists() {
		Boolean elementExists = driver.findElements(By.id("de.wetteronline.wetterapp:id/temperature")).size() > 0;
		Assert.assertTrue(elementExists);
	}
	
	@Test
	public void checkIfSunriseSunsetExists() {
		Boolean elementOneExists = driver.findElements(By.id("de.wetteronline.wetterapp:id/sunRiseIcon")).size() > 0;
		Assert.assertTrue(elementOneExists);
		
		Boolean elementTwoExists = driver.findElements(By.id("de.wetteronline.wetterapp:id/sunrise")).size() > 0;
		Assert.assertTrue(elementTwoExists);
		
		Boolean elementThreeExists = driver.findElements(By.id("de.wetteronline.wetterapp:id/sunset")).size() > 0;
		Assert.assertTrue(elementThreeExists);
	}
	
	@Test
	public void checkIfNowCastExists() {
		// Optional
	}
	
	@Test
	public void checkIfHourlyWeatherExists() {
		Boolean elementExists = driver.findElements(By.id("de.wetteronline.wetterapp:id/blurView")).size() > 0;
		Assert.assertTrue(elementExists);
	}
	
	@Test
	public void checkIfSkiingInfoExists() {
		// Optional
	}
	
	@Test
	public void checkIfAdExists() {
		Boolean elementExists = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View")).size() > 0;
		Assert.assertTrue(elementExists);
	}
	
	@Test
	public void checkIfWeatherRadarExists() throws InterruptedException {
		// TODO: Scroll
	}
	
	
	
	
}
