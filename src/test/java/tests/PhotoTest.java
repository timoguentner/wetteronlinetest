package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.MainPage;
import pages.MyPlacesPage;
import pages.NavigationDrawerPage;
import pages.PhotoPage;

public class PhotoTest extends BaseClass {

	private MyPlacesPage myPlaces;
	private MainPage mainPage;
	private NavigationDrawerPage navigationDrawer;
	private PhotoPage photoPage;
	
	private String placemarkName;
	private String temperature;
	private String deviceTime;
	
	@BeforeMethod
	public void navigateToMainPage() {
		
		BaseClass.resetApp = true;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Tap on the GPS button and allow location access
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		mainPage = new MainPage(driver);
	
		
		placemarkName = mainPage.getPlacemarkName();
		temperature   = mainPage.getTemperature();
		deviceTime    = driver.getDeviceTime().substring(11, 16);
		
		
		// Tap on the menu button in the navigation drawer
		mainPage.tapMenuButton();
		
		// Click on the photo menu item in the navigation drawer
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.photoDrawerButton.click();
	}
	
	@Test
	public void denyCameraPermission() {
		
		
		
		// Deny camera access
		driver.switchTo().alert().dismiss();
		
		// Check that the correct error message is displayed
		photoPage = new PhotoPage(driver);
		Assert.assertEquals(photoPage.cameraPermissinInfo.getText(), "Für die Foto-Funktion wird die Berechtigung \"Kamera\" benötigt");
	
	}
	
	@Test
	public void takePicture() {
		
		
		
		// Set implicit wait to 10 seconds
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Allow camera access
		driver.switchTo().alert().accept();
		
		
		// Tap on the shutter button to take a picture
		photoPage = new PhotoPage(driver);
		photoPage.shutterButton.click();
		photoPage.cameraDoneButton.click();
		
		
		
		
		 
		// Asserts
		Assert.assertEquals(photoPage.cityView.getText(), placemarkName);
		Assert.assertEquals(photoPage.timeView.getText(), deviceTime);
		Assert.assertTrue(photoPage.currentCastView.getText().contains(temperature));
		
	}
}
