package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.elements.composite.Form;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.createFromJSON;
import static com.epam.jdi.cucumber.Utils.getElementByName;

public class FormStepsEN {

    @When("^I submit form \"([^\"]*)\" data \"([^\"]*)\"$")
    public void iSubmitFormData(String formName, String json) {
        Form<Object> form = getElementByName(formName);
        Object entity = createFromJSON(json, form);
        form.submit(entity);
    }

    @When("^I fill form \"([^\"]*)\" data \"([^\"]*)\"$")
    public void iFillFormData(String formName, String json) {
        Form<Object> form = getElementByName(formName);
        Object entity = createFromJSON(json, form);
        form.fill(entity);
    }

    @Then("^form \"([^\"]*)\" contains data \"([^\"]*)\"$")
    public void formContainsData(String formName, String json) {
        Form<Object> form = getElementByName(formName);
        Object entity = createFromJSON(json, form);
        form.check(entity);
    }
}
