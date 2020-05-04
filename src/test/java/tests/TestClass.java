package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.MyPlacesPage;

public class TestClass extends BaseClass {

	@Test
	public void tapLocationButtonAndDismissAlert() {
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(false);
		
		Assert.assertEquals(myPlaces.getSnackbarText(), "Eine Ortung ist ohne die Berechtigung \"Standort\" nicht m�glich");
	
	}
	
	@Test
	public void tapLocationButtonAndAcceptAlert() {
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		 
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		// Assert
		
	}
	
	@Test
	public void openSidebar() {
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		
		// Assert
		
	}
	
	@Test
	public void addNewPlace() {
		
		String place = "K�ln";
		
		MyPlacesPage myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
		MainPage mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		myPlaces.searchForPlace(place);
		
		Assert.assertEquals(mainPage.getPlacemarkName(), place);
		
	}
	
	@Test
	public void deleteAllPlacesFromHistory() throws InterruptedException {
		
		String[] places = {"Berlin", "D�sseldorf", "Bremen", "M�nchen", "K�ln" };
		
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
}
