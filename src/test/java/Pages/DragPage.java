package Pages;

import Utilities.GWD;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DragPage extends GWD {
    public DragPage() {
        PageFactory.initElements(getAndroidDriver(), this);
    }
    public AppiumBy dragMenu = new AppiumBy.ByAccessibilityId("Drag");

    public By successMessage = By.xpath("//*[@text='Congratulations']");

    public  AppiumBy retryButton = new AppiumBy.ByAccessibilityId("button-Retry");

}
