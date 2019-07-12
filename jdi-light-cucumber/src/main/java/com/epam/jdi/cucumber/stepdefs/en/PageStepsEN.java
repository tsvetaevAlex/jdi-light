package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.getElementByName;
import static com.epam.jdi.uitests.core.interfaces.Application.currentSite;

public class PageStepsEN {

    @Given("^I open \"(.*?)\"$")
    public void iMOpen(String pageName) {
        currentPage = getElementByName(currentSite, pageName);
        WebPage.openUrl(currentPage);
    }

    @Then("^I'm on \"(.*?)\"$")
    public void iMOn(String pageName) {
        WebPage currentPage;
        currentPage = getElementByName(currentSite, pageName);
        currentPage.checkOpened();
    }

    @When("^I refresh page$")
    public void iMRefreshPage() {
        WebPage.refresh();
    }

    @When("^I go back$")
    public void iMGoBack() {
        WebPage.back();
    }

    @When("^I go forward$")
    public void iMGoForward() {
        WebPage.forward();
    }

    @Then("^I check that page url match$")
    public void checkPageUrlMatch() {
        WebPage.match();
    }

    @Then("^I check that page url contains$")
    public void checkPageUrlContains() {
        WebPage.getUrl().contains();
    }
}
