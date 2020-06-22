package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import base.BaseClass;
import pages.MainPage;
import pages.MyPlacesPage;

public class MyLocationsTest extends BaseClass {

	private MyPlacesPage myPlaces;
	private MainPage mainPage;
	
	@BeforeClass
	public void navigateToMainPage() {
		
		myPlaces = new MyPlacesPage(driver);
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(true);
		
	}
	
	/*
	@Test(enabled = true)
	public void tapLocationButtonAndDismissAlert() {
		
		myPlaces = new MyPlacesPage(driver);
		
		myPlaces.tapLocationsLocateButton();
		myPlaces.acceptLocationAccessAlert(false);
		
		Assert.assertEquals(myPlaces.getSnackbarText(), "Eine Ortung ist ohne die Berechtigung \"Standort\" nicht möglich");
		
	}
	*/
	
	@Test(enabled = false)
	public void addNewLocation() {
		
		String place = "Köln";
		
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		myPlaces.searchForPlace(place);
		
		Assert.assertEquals(mainPage.getPlacemarkName(), place);
		
	}
	
	@Test(enabled = false)
	public void deleteAllPlacesFromHistory() {
		
		String[] places = {"Berlin", "Düsseldorf", "Bremen", "München" };
		
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		for(int i = 0; i < places.length; i++) {
			myPlaces.searchForPlace(places[i]);
			
			mainPage.tapMenuButton();
			mainPage.tapMyPlacesButton();
		}
		
		myPlaces.tapEditButton();
		
		for(int i = places.length; i != 0; i--) {
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			Assert.assertEquals(myPlaces.getAmountOfLocationsInHistory(), i);
			
			myPlaces.deletePlace(2);
			
		}	
	}
}
