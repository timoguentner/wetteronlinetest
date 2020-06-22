package pages;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyPlacesPage {

	private AndroidDriver<AndroidElement> driver;
	
	public MyPlacesPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "locationsLocateImage")
	private AndroidElement locationsLocateButton;
	
	@AndroidFindBy(id = "snackbar_text")
	private AndroidElement snackbar;
	
	@AndroidFindBy(id = "searchEditText")
	private AndroidElement searchField;
	
	@AndroidFindBy(id = "action_edit")
	private AndroidElement editButton;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
	public AndroidElement pageHeadline;
	
	public void tapLocationsLocateButton() {
		locationsLocateButton.click();
	}
	
	public String getSnackbarText() {
		return snackbar.getText();
	}
	
	public void acceptLocationAccessAlert(boolean acceptAlert) {
		if(acceptAlert == true) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}
	
	public void searchForPlace(String place) {
		searchField.click();
		searchField.sendKeys(place);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void tapEditButton() {
		editButton.click();
	}
	
	public void deletePlace(int position) {
		AndroidElement placeDeleteButton = driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Ort löschen\"])["+position+"]");
		placeDeleteButton.click();
	}
	
	public int getAmountOfLocationsInHistory() {
		List<AndroidElement> historyElements = driver.findElementsById("weatherBackground");
		return historyElements.size() - 1;
	}
	
}
