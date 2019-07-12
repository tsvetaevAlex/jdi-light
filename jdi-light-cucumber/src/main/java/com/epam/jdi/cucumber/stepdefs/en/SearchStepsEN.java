package com.epam.jdi.cucumber.stepdefs.en;

import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.getElementByName;

public class SearchStepsEN {

    @When("^I find \"([^\"]*)\"$")
    public void iMFind(String findString) {
        Search search = getElementByName(currentSite, findString);
        search.find(findString);
    }
}
