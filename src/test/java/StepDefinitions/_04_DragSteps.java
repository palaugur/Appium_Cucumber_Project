package StepDefinitions;

import Pages.DragPage;
import Pages.SwipePage;
import Utilities.PageActionsHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.GWD.getAndroidDriver;

public class _04_DragSteps {
    DragPage dragPage = new DragPage();
    WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(20));
    PageActionsHelper actionsHelper = new PageActionsHelper();
    @When("Navigate to Drag Page")
    public void navigateToDragPage() {
        getAndroidDriver().findElement(dragPage.dragMenu).click();
    }

    @When("User complete Drag and Drop Game")
    public void userCompleteDragAndDropGame() {
        actionsHelper.dragAndDrop();
    }

    @Then("Success Message Should Display")
    public void successMessageShouldDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.successMessage));
        Assert.assertTrue(getAndroidDriver().findElement(dragPage.successMessage).isDisplayed());

    }
}
