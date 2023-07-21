package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'6 months or less')]")
    WebElement selectLess6mon;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'longer than 6 months')]")
    WebElement selectLong6mon;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;


    public void selectLengthOfStay(String moreOrLess) {
        Reporter.log("Clicking on long 6month radio button" + nextStepButton.toString());
        switch (moreOrLess) {
            case "1":
                clickOnElement(selectLess6mon);
            case "2":
                clickOnElement(selectLong6mon);
        }
    }

    public void clickNextStepButton() {
        Reporter.log("Clicking on Continue Button" + nextStepButton.toString());
        clickOnElement(nextStepButton);
    }
}
