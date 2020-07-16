package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import base.BaseClass;
import dataproviders.LocationsProvider;
import pages.MainPage;
import pages.MyPlacesPage;
import utilities.MySQLHelper;

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
	
	@Test(dataProvider="locations", dataProviderClass=LocationsProvider.class)
	public void addNewLocation2(String location) {
		
		BaseClass.resetApp = false;
		
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		myPlaces.searchForPlace(location);
		
		Assert.assertEquals(mainPage.getPlacemarkName(), location);
		
	}
	
	@Test(enabled = false)
	public void deleteAllRandomLocationsFromHistory() {
		
		MySQLHelper mySQLHelper = new MySQLHelper();
		
		ArrayList<String> locations = mySQLHelper.getFourRandomLocations();
		
		mainPage = new MainPage(driver);
		mainPage.tapMenuButton();
		mainPage.tapMyPlacesButton();
		
		for(int i = 0; i < locations.size(); i++) {
			myPlaces.searchForPlace(locations.get(i));
			
			mainPage.tapMenuButton();
			mainPage.tapMyPlacesButton();
		}
		
		myPlaces.tapEditButton();
		
		for(int i = locations.size(); i != 0; i--) {
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			Assert.assertEquals(myPlaces.getAmountOfLocationsInHistory(), i);
			
			myPlaces.deletePlace(2);
		
		}
	}
}
