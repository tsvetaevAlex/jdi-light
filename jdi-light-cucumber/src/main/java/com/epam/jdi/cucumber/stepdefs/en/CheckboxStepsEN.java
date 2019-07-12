package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.ui.html.common.Checkbox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.getElementByName;
import static com.epam.jdi.light.common.Exceptions.exception;

public class CheckboxStepsEN {

    @When("^I check \"([^\"]*)\"$")
    public void iMCheck(String fieldName) {
        Checkbox checkbox = getElementByName(fieldName);
        checkbox.check();
    }

    @When("^I uncheck \"([^\"]*)\"$")
    public void iMUncheck(String fieldName) {
        Checkbox checkbox = getElementByName(fieldName);
        checkbox.uncheck();
    }

    @Then("^checkbox \"([^\"]*)\" is checked$")
    public void checkboxIsCheck(String fieldName) {
        Checkbox checkbox = getElementByName(fieldName);
        if (!checkbox.isSelected()) {
            throw exception("Checkbox is not checked.");
        }
    }

    @Then("^checkbox \"([^\"]*)\" is unchecked$")
    public void checkboxIsUncheck(String fieldName) {
        Checkbox checkbox = getElementByName(fieldName);
        if (checkbox.isSelected()) {
            throw exception("Checkbox is checked.");
        }
    }
}
