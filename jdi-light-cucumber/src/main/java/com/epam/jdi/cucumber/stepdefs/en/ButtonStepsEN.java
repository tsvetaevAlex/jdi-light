package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.ui.html.common.Button;
import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.getElementByName;

public class ButtonStepsEN {

    @When("^I click on \"([^\"]*)\"(?:(?: button|link)$|$)")
    public void iMClickOnButton(String buttonName) {
        Button cl = getElementByName(buttonName);
        cl.click();
    }

    @When("^I click on \"([^\"]*)\" (?:(?: button|link)) from \"([^\"]*)\"$")
    public void iMClickOnLinkFrom(String fieldName, String containerName) {
        Button cl = getElementByName(containerName, fieldName);
        cl.click();
    }
}
