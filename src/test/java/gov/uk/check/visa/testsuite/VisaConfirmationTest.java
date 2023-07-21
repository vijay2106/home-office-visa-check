package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {

    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    WorkTypePage workTypePage;
    DurationOfStayPage durationOfStayPage;
    ResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        workTypePage = new WorkTypePage();
        durationOfStayPage = new DurationOfStayPage();
        resultPage = new ResultPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void anAustralianComingToUKForTourism() {
        //click on accept button
        startPage.acceptCookies();
        //click on hide button
        startPage.clickHideMessage();
        //  Click on start button
        startPage.clickStartNow();
        //	Select a Nationality 'Australia'
        selectNationalityPage.nationalityDropDownList("Australia");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //	verify result 'You will not need a visa to come to the UK'
        Assert.assertTrue(resultPage.getResultMessage().equalsIgnoreCase
                ("You will not need a visa to come to the UK"));
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        //click on accept button
        startPage.acceptCookies();
        //click on hide button
        startPage.clickHideMessage();
        //Click on start button
        startPage.clickStartNow();
        //	Select a Nationality 'Chile'
        selectNationalityPage.nationalityDropDownList("Chile");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //	Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("2");
        //	Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //	Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //	Click on Continue button
        workTypePage.clickNextStepButton();
        //	verify result 'You need a visa to work in health and care'
        Assert.assertTrue(resultPage.confirmResultMessage().equalsIgnoreCase
                ("You need a visa to work in health and care"));
    }

    @Test(groups = {"smoke", "regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        //click on accept button
        startPage.acceptCookies();
        //click on hide button
        startPage.clickHideMessage();
        //Click on start button
        startPage.clickStartNow();
        //	Select a Nationality 'Colombia'
        selectNationalityPage.nationalityDropDownList("Colombia");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //	Select state My partner of family member have uk immigration status 'yes'
        //	Click on Continue button
        //	verify result 'You may need a visa'
        Assert.assertTrue(resultPage.getResultMessage1().equalsIgnoreCase
                ("You may need a visa"));
    }
}