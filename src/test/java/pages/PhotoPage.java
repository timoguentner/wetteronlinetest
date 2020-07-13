package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PhotoPage {

	private AndroidDriver<AndroidElement> driver;

	public PhotoPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/cameraPermissionInfo")
	public AndroidElement cameraPermissinInfo;
	
	@AndroidFindBy(id = "com.android.camera2:id/shutter_button")
	public AndroidElement shutterButton;
	
	@AndroidFindBy(id = "com.android.camera2:id/done_button")
	public AndroidElement cameraDoneButton;
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/cityView")
	public AndroidElement cityView;
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/currentCastView")
	public AndroidElement currentCastView;
	
	@AndroidFindBy(id = "de.wetteronline.wetterapp:id/timeView")
	public AndroidElement timeView;
	
}
