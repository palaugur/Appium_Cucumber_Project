package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static Utilities.GWD.getAndroidDriver;

public class _01_LoginSteps {
    WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(20));
    LoginPage lp = new LoginPage();

    @Given("Open Application")
    public void openApplication() {
        getAndroidDriver();
    }

    @When("Navigate to Login Page")
    public void navigateToLoginPage() {
        getAndroidDriver().findElement(lp.loginMenu).click();
    }

    @And("Enter Valid Credentials and Click Login Button")
    public void enterValidCredentialsAndClickLoginButton() {
        getAndroidDriver().findElement(lp.usernameInput).sendKeys("username123@gmail.com");
        getAndroidDriver().findElement(lp.passwordInput).sendKeys("password123!");
        getAndroidDriver().findElement(lp.loginButton).click();
    }

    @Then("User Should Login Successfully")
    public void userShouldLoginSuccessfully() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(lp.successfulLoginMessage)).getText();
        Assert.assertEquals(actualText, "You are logged in!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lp.loginOkButton));
        getAndroidDriver().findElement(lp.loginOkButton).click();
    }
}
