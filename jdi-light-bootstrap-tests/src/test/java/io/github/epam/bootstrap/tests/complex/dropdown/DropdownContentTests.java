package io.github.epam.bootstrap.tests.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownContentWithHeader;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class DropdownContentTests extends TestsInit {

    private String headerText = "Dropdown header";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void checkHeaderTest() {
//        dropdownContentWithHeader.is().displayed();
        dropdownContentWithHeader.header.is()
                .displayed()
                .text(headerText.toUpperCase());
    }

    @Test()
    public void clickHeaderShouldFail() {
        dropdownContentWithHeader.header.
    }
}
