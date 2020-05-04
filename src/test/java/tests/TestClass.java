package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;
import pages.MainPage;
import pages.MyPlacesPage;

public class TestClass extends BaseClass {

	/*
	@Test
	public void tapLocationButtonAndDismissAlert() {
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		
		// Tap on the GPS-button to the right of the "Ort" search field 
		myPlaces.tapLocationsLocateButton();
		
		// Dismiss the location access permission
		myPlaces.acceptLocationAccessAlert(false);
		
		// Check if the correct text is displayed in the snackbar
		Assert.assertEquals(myPlaces.getSnackbarText(), "Eine Ortung ist ohne die Berechtigung \"Standort\" nicht möglich");
	}
	*/
	
	/*
	@Test
	public void tapLocationButtonAndAcceptAlert() throws InterruptedException {
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		
		// Tap on the GPS-button to the right of the "Ort" search field 
		myPlaces.tapLocationsLocateButton();
		
		// Accept the location access permission
		myPlaces.acceptLocationAccessAlert(true);
		
		// Check whether activity was changed or not
		
	}
	*/
	
	/*
	@Test
	public void openSidebar() throws InterruptedException {
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapOnMenuButton();
	}
	*/
	
	/*
	@Test
	public void addNewPlace() throws InterruptedException {
		
		String place = "Köln";
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		myPlaces.searchForPlace(place);
		
		Assert.assertEquals(mainPage.getPlacemarkName(), place);
	}
	*/
	
	@Test
	public void deleteAllPlaces() throws InterruptedException {
		
		String[] places = {"Berlin", "Düsseldorf", "Bremen", "München", "Köln" };
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		for(int i = 0; i < places.length; i++) {
			myPlaces.searchForPlace(places[i]);
			
			mainPage.tapMenuButton();
			mainPage.tapMyPlacesButton();
		}
		
		myPlaces.tapEditButton();
		
		for(int i = 0; i < places.length; i++) {
			myPlaces.deletePlace(2);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
