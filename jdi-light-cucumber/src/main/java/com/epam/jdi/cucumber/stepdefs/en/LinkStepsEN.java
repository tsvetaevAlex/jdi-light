package com.epam.jdi.cucumber.stepdefs.en;

import com.epam.jdi.light.ui.html.common.Link;
import cucumber.api.java.en.Then;

import static com.epam.jdi.cucumber.Utils.getElementByName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;

public class LinkStepsEN {

    @Then("^link \"([^\"]*)\" from \"([^\"]*)\" contains reference \"([^\"]*)\"$")
    public void linkFromContains(String linkName, String containerName, String contains) {
        Link link = getElementByName(containerName, linkName);
        assertThat(link.ref(), containsString(contains));
    }

    @Then("^link \"([^\"]*)\" from \"([^\"]*)\" match reference \"([^\"]*)\"$")
    public void linkFromMuchReference(String linkName, String containerName, String regex) {
        Link link = getElementByName(containerName, linkName);
        assertEquals(link.ref(), regex);
    }
}
