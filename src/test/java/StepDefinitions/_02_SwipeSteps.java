package StepDefinitions;

import Pages.SwipePage;
import Utilities.PageActionsHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

import static Utilities.GWD.getAndroidDriver;

public class _02_SwipeSteps {
    WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(20));
    SwipePage swipePage = new SwipePage();
    PageActionsHelper actionsHelper = new PageActionsHelper();

    @When("Navigate To Swipe Page")
    public void navigateToSwipePage(){
        getAndroidDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageText));
    }

    @And("Scroll Down")
    public void scrollDown() {
        actionsHelper.performScroll("down");
    }

    @Then("Logo Should Be Visible")
    public void logoShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.logo));
        Assert.assertTrue(getAndroidDriver().findElement(swipePage.logo).isDisplayed());
        if(getAndroidDriver().findElement(By.xpath("//*[@text='You found me!!!']")).isDisplayed()){
            System.out.println("I found you!");
        }
    }
    @And("Scroll Right")
    public void scrollRight() {
        List<WebElement> listOfbuttons = getAndroidDriver().findElements(swipePage.allButtons);
        for (int i = 0; i < listOfbuttons.size(); i++) {
            actionsHelper.performScroll("right");
        }
    }

    @Then("Last Element Should Be Visible")
    public void lastElementShouldBeVisible() {
        Assert.assertTrue(getAndroidDriver().findElement(swipePage.lastElement).isDisplayed());
    }
}
