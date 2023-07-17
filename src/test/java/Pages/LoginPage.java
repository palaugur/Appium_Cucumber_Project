package Pages;


import Utilities.GWD;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GWD {

    public LoginPage() {
        PageFactory.initElements(getAndroidDriver(), this);
    }

    public AppiumBy loginMenu = new AppiumBy.ByAccessibilityId("Login");
    public AppiumBy usernameInput = new AppiumBy.ByAccessibilityId("input-email");
    public AppiumBy passwordInput = new AppiumBy.ByAccessibilityId("input-password");
    public AppiumBy loginButton = new AppiumBy.ByAccessibilityId("button-LOGIN");
    public By successfulLoginMessage = By.id("android:id/message");
    public By loginOkButton = new By.ById("android:id/button1");



}
