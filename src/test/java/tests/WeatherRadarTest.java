package tests;

import java.util.ArrayList;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.MainPage;
import pages.MyPlacesPage;
import pages.NavigationDrawerPage;
import pages.WeatherRadarPage;

public class WeatherRadarTest extends BaseClass {

	private MyPlacesPage myPlaces;
	private WeatherRadarPage weatherRadar;
	private MainPage mainPage;
	private NavigationDrawerPage navigationDrawer;
	
	@BeforeClass
	public void navigateToWeatherRadar() throws InterruptedException {
		
		// Do not reset the app after each test
		BaseClass.resetApp = false;
		
		// Tap on the GPS button and allow location access
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		// Tap on the hamburger button
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		
		// Tap on the WeatherRadar menu item in the navigation drawer
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.weatherRadarDrawerButton.click();
		
		// Wait for the clock to appear
		Thread.sleep(3000);
	}
	
	
	@Test(enabled = true)
	public void FifteenMinPredictionTest() {
		// Get current clock time
		weatherRadar = new WeatherRadarPage(driver);
		String currentClockTime = weatherRadar.getClockTime();
		
		// Parse clock time
	    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("HH:mm");
	    LocalTime time = dateTimeFormatter.parseLocalTime(currentClockTime);
	    
	    // Add 15 minutes each to the currentClockTime
	    ArrayList<String> expectedTimes = new ArrayList<String>();
	    for(int i = 0; i < 6; i++) {
	    	time = time.plusMinutes(15);
	    	expectedTimes.add(dateTimeFormatter.print(time));
	    }
	    
	    // Start the cycle, Wait until the calculated time is displayed, Restart the cycle
	    WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
	    for(int i = 0; i < 6; i++) {
	    	weatherRadar.playPauseButton.click();
	    	webDriverWait.until(ExpectedConditions.textToBePresentInElement(weatherRadar.clock, expectedTimes.get(i)));
	    	weatherRadar.playPauseButton.click();
	    }
	}
	
	@Test(enabled = false)
	public void switchToRainRadar() {
		
		// Switch to RainRadar
		weatherRadar = new WeatherRadarPage(driver);
		weatherRadar.switcherButton.click();
		weatherRadar.rainRadarButton.click();
		
		// Assert
		Assert.assertEquals(weatherRadar.pageHeadline.getText(), "RegenRadar");
	}
}