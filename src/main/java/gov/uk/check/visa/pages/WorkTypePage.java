package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Health and care professional')]")
    WebElement selectJobtypeList;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    public void selectJobType(String job) {
        Reporter.log("Clicking on Health and care professional Radio Button" + selectJobtypeList.toString());
        clickOnElement(selectJobtypeList);
    }

    public void clickNextStepButton() {
        Reporter.log("Clicking on Continue Button" + nextStepButton.toString());
        clickOnElement(nextStepButton);

    }
}
