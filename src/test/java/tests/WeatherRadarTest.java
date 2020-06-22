package tests;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

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
		
		// TODO
		BaseClass.resetApp = false;
		
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.weatherRadarDrawerButton.click();
		
		Thread.sleep(3000);
	}
	
	
	@Test(enabled = true)
	public void FifteenMinPredictionTest() throws ParseException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		weatherRadar = new WeatherRadarPage(driver);
		weatherRadar.playPauseButton.click();
		
		String currentClockTime = weatherRadar.getClockTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = sdf.parse(currentClockTime);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		long timeInMillis = calendar.getTimeInMillis() + 3600000;
		
		ArrayList<String> futureTimes = new ArrayList<String>();

		for(int i = 1; i < 7; i++) {
			long timeInMillis_ = timeInMillis + (900000 * i);
			
			String time = String.format("%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(timeInMillis_),
				TimeUnit.MILLISECONDS.toMinutes(timeInMillis_) - 
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeInMillis_)));
			
			futureTimes.add(time);
		}
		
		String[] predictedTimes = new String[6];
		String[] actualTimes    = new String[6];
		
		for(int i = 0; i < 6; i++) {
			predictedTimes[i] = futureTimes.get(i);
			actualTimes[i]    = weatherRadar.getClockTime();
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println(predictedTimes[i]);
			System.out.println(actualTimes[i]);
			
			Assert.assertEquals(actualTimes[i], predictedTimes[i]);
		}
	}
	
	@Test(enabled = false)
	public void switchToRainRadar() {
		
		weatherRadar = new WeatherRadarPage(driver);
		weatherRadar.switcherButton.click();
		weatherRadar.rainRadarButton.click();
		
		Assert.assertEquals(weatherRadar.pageHeadline.getText(), "RegenRadar");
		
	}
	
	
	
}

