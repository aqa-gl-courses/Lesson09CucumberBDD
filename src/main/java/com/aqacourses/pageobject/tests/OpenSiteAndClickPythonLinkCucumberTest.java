package com.aqacourses.pageobject.tests;

import com.aqacourses.pageobject.base.BaseTest;
import com.aqacourses.pageobject.pages.HomePage;
import com.aqacourses.pageobject.pages.PythonPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OpenSiteAndClickPythonLinkCucumberTest extends BaseTest {

    private HomePage homePage;
    private PythonPage pythonPage;
    private String actualTitle;

    @Given("The user opens site sees Home Page")
    public void theUserOpensSiteSeesHomePage() {
        homePage = openSite();
    }

    @When("He clicks Python link sees Python page")
    public void heClicksPythonLinkSeesPythonPage() {
        pythonPage = homePage.clickPythonLink();
    }

    @When("He verify title on Python Page")
    public void heVerifyTitleOnPythonPage() {
        actualTitle = getDriver().getTitle();
    }

    @Then("Title is '([^\"]*)'")
    public void titleIs(String expectedTitle) {
        Assert.assertEquals("Titles are not the same", expectedTitle, actualTitle);
    }

    @When("He clicks Home link")
    public void heClicksHomeLink() {
        homePage = pythonPage.clickHomeLink();
    }

    @Then("User closes browser")
    public void userClosesBrowser() {
        closeSite();
    }
}
