package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Accept additional cookies']")
    WebElement acceptCookies;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Hide this message')]")
    WebElement hideMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Start now']")
    WebElement startNowButton;

    public void clickStartNow(){
        Reporter.log("Clicking on login link" + startNowButton.toString());
        clickOnElement(startNowButton);
    }
    public void acceptCookies()
    {
        Reporter.log("Clicking on Accept button" + acceptCookies.toString());
        clickOnElement(acceptCookies);
    }
    public void clickHideMessage()
    {
        Reporter.log("Clicking on Hide button" + hideMessage.toString());
        //click on hide button
        clickOnElement(hideMessage);
    }


}
