package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
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
		this.searchElementByContentDescription("Menü öffnen");
	}
	
	@Test
	public void checkIfMagnifierExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/action_search");
	}
	
	@Test
	public void checkIfTemperatureExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/temperature");
	}
	
	@Test(enabled = false)
	public void checkIfSunriseSunsetExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/sunRiseIcon");
		this.searchElementById("de.wetteronline.wetterapp:id/sunrise");
		this.searchElementById("de.wetteronline.wetterapp:id/sunset");
	}
	
	@Test
	public void checkIfHourlyWeatherExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/hourcast");
	}
	
	@Test
	public void checkIfAdExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/adContainer");
	}
	
	@Test
	public void checkIfWeatherRadarExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/snippet");
	}
	
	@Test
	public void checkIfWetterOnlineHomeInfoExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/woHomeAdView");
	}
	
	@Test
	public void checkIfWeatherPredictionExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/cardHeader");
		this.searchElementById("de.wetteronline.wetterapp:id/dayPartsContainer");
		this.searchElementById("de.wetteronline.wetterapp:id/daysRecyclerView");
	}
	
	@Test
	public void checkIfTopTopicExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/streamTopNews");
		this.searchElementById("de.wetteronline.wetterapp:id/moreLink");
	}
	
	@Test
	public void checkIfFourteenDayWeatherExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/cardHeader");
		this.searchElementById("de.wetteronline.wetterapp:id/longcastTable");
	}
	
	@Test
	public void checkIfMoreNewsSectionExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/streamTopNews");
	}
	
	@Test
	public void checkIfPhotoButtonExists() {
		this.searchElementById("de.wetteronline.wetterapp:id/photo_teaser_img_icon");
		this.searchElementById("de.wetteronline.wetterapp:id/photo_teaser_txt_title");
	}
	
	// TODO: Move to helper class
	private void searchElementById(String resourceId) {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollIntoView(new UiSelector().resourceIdMatches(\"" + resourceId + "\"))"));
		}
		catch(Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	private void searchElementByContentDescription(String contentDescription) {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(30)" +
			    ".scrollIntoView(new UiSelector().descriptionMatches(\"" + contentDescription + "\"))"));
		}
		catch(Exception e) {
			Assert.fail(e.toString());
		}
	}
}
