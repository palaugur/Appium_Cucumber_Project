package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GWD {
    private static AndroidDriver driver;

    public static AndroidDriver getAndroidDriver() {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setPlatformVersion("11.0");
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
            options.setDeviceName("Samsung");
            options.setAppPackage("com.wdiodemoapp");
            options.setAppActivity("com.wdiodemoapp.MainActivity");
           // options.setUdid("***********"); //Device ID for real device testing

            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void closeApp() {

        if (driver != null) {
            driver.quit();
            driver = null;

        }

    }
}
