package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NinetyMinWeatherPage {

	private AndroidDriver<AndroidElement> driver;

	public NinetyMinWeatherPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "locationText")
	private AndroidElement locationText;
	
	@AndroidFindBy(id = "nowcastPlayPauseImageView")
	private AndroidElement playPauseButton;
	
	@AndroidFindBy(id = "weatherClockText")
	private AndroidElement weatherClockText;
	
	public String getLocationText() {
		return locationText.getText();
	}
	
	public void tapPlayPauseButton() {
		playPauseButton.click();
	}
	
	public String getWeatherClockTime() {
		return weatherClockText.getText();
	}
	
}
