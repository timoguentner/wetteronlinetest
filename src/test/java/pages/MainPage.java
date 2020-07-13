package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPage {

	private AndroidDriver<AndroidElement> driver;
	
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menü öffnen\"]")
	private AndroidElement menuButton;
	
	@AndroidFindBy(id = "label") // XPath
	private AndroidElement myPlacesButton;
	
	@AndroidFindBy(id = "placemarkName")
	public AndroidElement placemarkName;
	
	@AndroidFindBy(id = "nowcastButton")
	private AndroidElement nowcastButton;
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/temperature")
	private AndroidElement temperature;
	
	public void tapMenuButton() {
		menuButton.click();
	}
	
	public void tapMyPlacesButton() {
		myPlacesButton.click();
	}
	
	public String getPlacemarkName() {
		return placemarkName.getText();
	}
	
	public AndroidElement getNowcastButton() {
		return nowcastButton;
	}
	
	public String getTemperature() {
		return temperature.getText();
	}
	
	
	
	
	
}
