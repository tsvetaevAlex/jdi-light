package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.ui.html.common.TextField;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.epam.jdi.cucumber.Utils.getElementByName;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;

public class TextStepsEN {

    @And("^I fill field \"([^\"]*)\" by text \"([^\"]*)\"$")
    public void iMFillFieldByText(String fieldName, String text) {
        TextField textField = getElementByName(fieldName);
        textField.sendKeys(text);
    }

    @Then("^(?:text|label|link|button) \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void textFromContains(String fieldName, String contains) {
        TextField text = getElementByName(fieldName);
        text.waitFor().text(containsString(contains));
    }

    @Then("^(?:text|label|link|button) \"([^\"]*)\" match \"([^\"]*)\"$")
    public void textFromMach(String fieldName, String regex) {
        TextField text = getElementByName(fieldName);
        text.waitFor().text(is(regex));
    }

    @Then("^(?:text|label|link|button) \"([^\"]*)\" from \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void textFromContains(String linkName, String containerName, String contains) {
        TextField text = getElementByName(containerName, linkName);
        text.waitFor().text(containsString(contains));
    }

    @Then("^(?:text|label|link|button) \"([^\"]*)\" from \"([^\"]*)\" match \"([^\"]*)\"$")
    public void textFromMuch(String linkName, String containerName, String regex) {
        TextField text = getElementByName(containerName, linkName);
        text.waitFor().text(is(regex));
    }
}
