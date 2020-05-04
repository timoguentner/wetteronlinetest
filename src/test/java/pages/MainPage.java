package pages;

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
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/label")
	private AndroidElement myPlacesButton;
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/placemarkName")
	private AndroidElement placemarkName;
	
	public void tapMenuButton() {
		menuButton.click();
	}
	
	public void tapMyPlacesButton() {
		myPlacesButton.click();
	}
	
	public String getPlacemarkName() {
		return placemarkName.getText();
	}
	
	
	
}
