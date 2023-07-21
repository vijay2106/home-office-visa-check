package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//div//label")
    List<WebElement> reasonForVisitList;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;



    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'')]")
    WebElement selectlongstay;


    public void selectReasonForVisit(String reason) {
        Reporter.log("Clicking on Reason for visit" + nextStepButton.toString());
        for (WebElement element : reasonForVisitList) {
            if (element.getText().contains(reason)) {
                clickOnElement(element
                );
                break;
            }
        }
    }


    public void clickNextStepButton() {
        Reporter.log("Clicking on Continue Button" + nextStepButton.toString());
        clickOnElement(nextStepButton);


    }
}
