package gov.uk.check.visa.pages;

import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement resultMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement heathcarevisaText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You may need a visa')]")
    WebElement needVisaMessage;

    public String getResultMessage() {
        Reporter.log("Getting You will not need a visa to come to the UK  Message");
        return getTextFromElement(resultMessage);
    }

    public String confirmResultMessage() {
        Reporter.log("Getting You need a visa to work in health and care Message");
        return getTextFromElement(heathcarevisaText);

    }

    public String getResultMessage1() {
        Reporter.log("Getting You may need a visa Message");
        return getTextFromElement(needVisaMessage);
    }
}
