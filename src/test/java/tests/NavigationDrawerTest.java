package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.MainPage;
import pages.MyPlacesPage;
import pages.NavigationDrawerPage;
import pages.RainRadarPage;
import pages.WeatherRadarPage;

public class NavigationDrawerTest extends BaseClass {
	
	private MainPage mainPage;
	private MyPlacesPage myPlaces;
	private NavigationDrawerPage navigationDrawer;
	
	@BeforeClass
	public void navigateToMainPage() {
		BaseClass.resetApp = false;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
	}
	
	@BeforeMethod
	public void tapHamburgerButton() {
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
	}
	
	@Test
	public void tapMyLocationsDrawerButton() {
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.myPlacesDrawerButton.click();
		
		Assert.assertEquals(myPlaces.pageHeadline.getText(), "Meine Orte");
	}
	
	@Test
	public void tapWeatherDrawerButton() {
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.weatherDrawerButton.click();
		
		mainPage = new MainPage(driver);
		
		Assert.assertEquals(mainPage.placemarkName.isDisplayed(), true);
	}
	
	@Test
	public void tapWeatherRadarDrawerButton() {
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.weatherRadarDrawerButton.click();
		
		WeatherRadarPage weatherRadar = new WeatherRadarPage(driver);
		
		Assert.assertEquals(weatherRadar.pageHeadline.getText(), "WetterRadar");
	}
	
	@Test
	public void tapRainRadarDrawerButton() {
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.rainRadarDrawerButton.click();
		
		RainRadarPage rainRadar = new RainRadarPage(driver);
		
		Assert.assertEquals(rainRadar.pageHeadline.getText(), "RegenRadar");
	}
	
	@Test(enabled = false)
	public void tapWeatherNewsDrawerButton() { }
	
	@Test(enabled = false)
	public void tapPhotoDrawerButton() { }
	
	@AfterMethod
	private void goBack() {
		driver.navigate().back();
	}
}
