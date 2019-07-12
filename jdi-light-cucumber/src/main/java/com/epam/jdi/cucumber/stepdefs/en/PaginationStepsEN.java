package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.cucumber.Utils;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JPagination;
import cucumber.api.java.en.When;

import static com.epam.jdi.cucumber.Utils.getElementByName;

public class PaginationStepsEN {

    @When("^On pagination \"([^\"]*)\" I press next$")
    public void iMUsePaginationToGoNext(String paginationName) {
        ((JPagination) Utils.getClassField(currentPage, paginationName)).next();
    }

    @When("^On pagination \"([^\"]*)\" I press previous$")
    public void iMUsePaginationToGoPrevious(String paginationName) {
        JPagination pagination = getElementByName(paginationName);
        pagination.prev();
    }

    @When("^On pagination \"([^\"]*)\" I select page number (\\d+)$")
    public void iMUsePaginationToSelect(String paginationName, int index) {
        JPagination pagination = getElementByName(paginationName);
        pagination.selectPage(index);
    }

    @When("^On pagination \"([^\"]*)\" I go to last$")
    public void iMUsePaginationToGoLast(String paginationName) {
        JPagination pagination = getElementByName(paginationName);
        pagination.last();
    }

    @When("^On pagination \"([^\"]*)\" I go to first$")
    public void iMUsePaginationToGoFirst(String paginationName) {
        JPagination pagination = getElementByName(paginationName);
        pagination.first();
    }
}
