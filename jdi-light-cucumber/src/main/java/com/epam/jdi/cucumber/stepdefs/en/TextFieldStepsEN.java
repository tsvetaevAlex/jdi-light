package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.ui.html.common.TextField;
import cucumber.api.java.en.Given;

import static com.epam.jdi.cucumber.Utils.getElementByName;

public class TextFieldStepsEN {

    @Given("^I fill \"([^\"]*)\" textfield with \"([^\"]*)\"$")
    public void iMFillBy(String fieldName, String data) {
        TextField textField = getElementByName(fieldName);
        textField.setValue(data);
    }
}
