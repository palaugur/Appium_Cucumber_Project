package StepDefinitions;

import Pages.FormsPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import static Utilities.GWD.getAndroidDriver;

public class _03_FormsSteps {
    WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(20));
    FormsPage formsPage = new FormsPage();
    @When("Navigate To Forms Page")
    public void navigateToFormsPage() {
        getAndroidDriver().findElement(formsPage.formsMenu).click();
    }

    @When("User Turns On Switch")
    public void userTurnsOnSwitch() {
        String switchTextBeforeClick = getAndroidDriver().findElement(formsPage.switchText).getText();
        //System.out.println(switchTextBeforeClick);
        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        GWD.getAndroidDriver().findElement(formsPage.switchButton).click();
    }

    @Then("The Switch Should Be Turned On")
    public void theSwitchShouldBeTurnedOn() {
        String switchTextAfterClick = getAndroidDriver().findElement(formsPage.switchText).getText();
        //System.out.println(switchTextAfterClick);
        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");

    }

    @When("User Opens Dropdown Menu")
    public void userOpensDropdownMenu() {
        getAndroidDriver().findElement(formsPage.dropdownButton).click();

    }

    @And("Selects Second Option")
    public void selectsSecondOption() {
        getAndroidDriver().findElement(formsPage.secondOption).click();

    }

    @Then("Second Option Should Be Selected")
    public void secondOptionShouldBeSelected() {
        //System.out.println(fp.actualText);
        String actualText = getAndroidDriver().findElement(formsPage.textElement).getText();
        Assert.assertEquals(actualText, "Appium is awesome");

        getAndroidDriver().findElement(formsPage.dropdownButton).click();
        String isSelected = getAndroidDriver().findElement(formsPage.secondOption).getAttribute("checkable");
        //System.out.println("Is element selected = " + fp.isSelected);
        Assert.assertEquals(isSelected, "true");
    }
}
