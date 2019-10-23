package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.common.TextTypes;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownContentWithHeader;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.hasItem;

public class DropdownContentTests extends TestsInit {

    private String headerText = "DROPDOWN HEADER";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseTest() {
        baseValidation(dropdownContentWithHeader);
        dropdownContentWithHeader.unhighlight();
    }

    @Test
    public void checkHeaderTest() {
        dropdownContentWithHeader.is().displayed();
        dropdownContentWithHeader.items.is().values(TextTypes.TEXT, hasItem(headerText));
        dropdownContentWithHeader.header.is()
                .displayed()
                .text(headerText);
    }


}
