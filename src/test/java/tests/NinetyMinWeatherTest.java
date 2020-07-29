package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.MainPage;
import pages.MyPlacesPage;
import pages.NinetyMinWeatherPage;

public class NinetyMinWeatherTest extends BaseClass {

	private MyPlacesPage myPlaces;
	private MainPage mainPage;
	private NinetyMinWeatherPage ninetyMinWeather;
	
	private String location = "Köln";
	
	@BeforeClass
	public void navigateToNinetyMinWeatherPage() {
		BaseClass.resetApp = false;
		
		myPlaces = new MyPlacesPage(driver);
		myPlaces.searchForPlace(location);
		
		mainPage = new MainPage(driver);
		mainPage.getNowcastButton().click();
	}
	
	@Test(enabled = true)
	public void verifyLocationText() {
		ninetyMinWeather = new NinetyMinWeatherPage(driver);
		
		Assert.assertEquals(ninetyMinWeather.getLocationText(), "Köln");
	}
	
	@Test(enabled = true)
	public void checkIfWeatherClockTimeChanges() {
		ninetyMinWeather = new NinetyMinWeatherPage(driver);
		
		String weatherClockTime;
		
		try {
			for(int i = 0; i < 7; i++) {	
				weatherClockTime = ninetyMinWeather.getWeatherClockTime();
				
				Thread.sleep(1500);

				Assert.assertNotEquals(ninetyMinWeather.getWeatherClockTime(), weatherClockTime);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
