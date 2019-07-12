package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.elements.base.UIElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.getElementByName;
import static org.testng.Assert.assertEquals;

public class ElementStepsEN {

    @When("^for element \"([^\"]*)\" I set attribute \"([^\"]*)\" on \"([^\"]*)\"$")
    public void forElementISetAttributeOn(String fieldName, String attributeName, String attributeValue) {
        UIElement el = getElementByName(fieldName);
        el.setAttribute(attributeName, attributeValue);
    }

    @Then("^element \"([^\"]*)\" has attribute \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void elementHasAttributeWithValue(String fieldName, String attributeName, String attributeValue) {
        UIElement el = getElementByName(fieldName);
        assertEquals(attributeValue, el.getAttribute(attributeName));
    }
}