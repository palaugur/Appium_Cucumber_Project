package Pages;

import Utilities.GWD;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends GWD {

    public FormsPage() {
        PageFactory.initElements(getAndroidDriver(), this);
    }

    public AppiumBy formsMenu = new AppiumBy.ByAccessibilityId("Forms");

    //Dropdown Locators
    public AppiumBy dropdownButton = (AppiumBy) AppiumBy.accessibilityId("Dropdown");
    public By secondOption = By.xpath("//*[@text='Appium is awesome']");
    public By textElement = By.xpath("//android.view.ViewGroup[@content-desc='Dropdown']/android.view.ViewGroup/android.widget.EditText");

    //Switch Locators
    public AppiumBy switchText = (AppiumBy) AppiumBy.accessibilityId("switch-text");
    public AppiumBy switchButton = (AppiumBy) AppiumBy.accessibilityId("switch");

}
