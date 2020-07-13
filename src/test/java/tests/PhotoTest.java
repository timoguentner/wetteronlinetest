package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
	
	@BeforeClass
	public void navigateToMainPage() {
		
		// Tap on the GPS button and allow location access
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		mainPage = new MainPage(driver);
	
		// Read out the relevant values for checking the photo function
		placemarkName = mainPage.getPlacemarkName();
		temperature   = mainPage.getTemperature();
		deviceTime    = driver.getDeviceTime().substring(11, 16);
		
		// Tap on the menu button in the navigation drawer
		mainPage.tapMenuButton();
		
		// Click on the photo menu item in the navigation drawer
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.photoDrawerButton.click();
	}
	
	@Test(enabled = false)
	public void denyCameraPermission() {
		
		// Deny camera access
		driver.switchTo().alert().dismiss();
		
		// Check that the correct error message is displayed
		photoPage = new PhotoPage(driver);
		Assert.assertEquals(photoPage.cameraPermissinInfo.getText(), "F�r die Foto-Funktion wird die Berechtigung \"Kamera\" ben�tigt");
	
	}
	
	@Test(enabled = true)
	public void takePicture() {
		
		// Set implicit wait to 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Allow camera access
		driver.switchTo().alert().accept();
		
		// Tap on the shutter button to take a picture
		photoPage = new PhotoPage(driver);
		photoPage.shutterButton.click();
		photoPage.cameraDoneButton.click();
		 
		// Asserts
		Assert.assertEquals(photoPage.cityView.getText(), this.placemarkName);
		Assert.assertEquals(photoPage.timeView.getText(), this.deviceTime);
		Assert.assertTrue(photoPage.currentCastView.getText().contains(this.temperature));
		
	}
}
