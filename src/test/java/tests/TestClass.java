package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import base.BaseClass;
import pages.MainPage;
import pages.MyPlacesPage;

public class TestClass extends BaseClass {

	@Test(enabled = false)
	public void tapLocationButtonAndDismissAlert() {
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(false);
		
		Assert.assertEquals(myPlaces.getSnackbarText(), "Eine Ortung ist ohne die Berechtigung \"Standort\" nicht möglich");
		
	}
	
	@Test(enabled = false)
	public void tapLocationButtonAndAcceptAlert() {
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		 
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		// Assert
		
	}
	
	@Test(enabled = false)
	public void openSidebar() {
			
		tapLocationButtonAndAcceptAlert();
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		
		// Assert
		
	}
	
	@Test(enabled = false)
	public void addNewPlace() {
		
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
	
	@Test(enabled = false)
	public void deleteAllPlacesFromHistory() {
		
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
		
		// Assert
		
	}
	
	@Test
	public void tapEveryDrawerButton() throws InterruptedException {
		tapLocationButtonAndAcceptAlert();
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		
		mainPage.weatherDrawerButton.click();
		
		Thread.sleep(5000);
	}
	
}
