package Pages;

import Utilities.GWD;
import io.appium.java_client.AppiumBy;
import org.apache.commons.digester.annotations.rules.SetTop;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SwipePage extends GWD {
    public SwipePage(){
        PageFactory.initElements(getAndroidDriver(),this);
    }

public AppiumBy swipeMenu = new AppiumBy.ByAccessibilityId("Swipe");
    public By swipePageText = By.xpath("//*[@text='Swipe horizontal']");
    public AppiumBy logo = new AppiumBy.ByAccessibilityId("WebdriverIO logo");
    public By allButtons = By.xpath("//android.view.ViewGroup[@content-desc='Carousel']/android.view.ViewGroup/android.view.ViewGroup");

    public By lastElement = By.xpath("(//android.view.ViewGroup[@content-desc='card'])[2]/android.widget.TextView");
}

