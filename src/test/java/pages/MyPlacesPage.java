package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyPlacesPage {

	private AndroidDriver<AndroidElement> driver;
	
	public MyPlacesPage() { }
	
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
	
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Ort löschen\"])[2]")
	private AndroidElement placeDeleteButtonTwo;
	
	public void tapLocationsLocateButton() {
		locationsLocateButton.click();
	}
	
	public String getSnackbarText() {
		return snackbar.getText();
	}
	
	public void acceptLocationAccessAlert(boolean acceptAlert) {
		if(acceptAlert == true) {
			driver.switchTo().alert().accept();
		} else if(acceptAlert == false) {
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
}
