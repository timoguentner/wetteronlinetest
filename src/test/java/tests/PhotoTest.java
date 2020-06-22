package tests;

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
	
	@BeforeClass
	public void navigateToMainPage() {
		BaseClass.resetApp = false;
		
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		
		navigationDrawer = new NavigationDrawerPage(driver);
		navigationDrawer.photoDrawerButton.click();
	}
	
	@Test
	public void denyCameraPermission() {
		driver.switchTo().alert().dismiss();
		
		photoPage = new PhotoPage(driver);
		
		Assert.assertEquals(photoPage.cameraPermissinInfo.getText(), "Für die Foto-Funktion wird die Berechtigung \"Kamera\" benötigt");
	}
	
	@Test
	public void takePicture() {
		
	}
	
}
