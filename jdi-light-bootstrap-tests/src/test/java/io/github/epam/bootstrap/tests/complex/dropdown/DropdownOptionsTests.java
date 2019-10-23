package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Dropdown;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.offsetDropdown;
import static io.github.com.pages.BootstrapPage.referenceDropdown;
import static io.github.com.pages.BootstrapPage.simpleDropdown;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Mariia Tikhonova on 23.10.2019
 * Email: mariia_tikhonova@epam.com, Skype: mariatikhonova5_2
 */

public class DropdownOptionsTests extends TestsInit {

    private static final String DROPDOWN = "Dropdown";
    private static final String FIRSTITEM = "Action";
    private static final String SECONDITEM = "Another\n                                        action";
    private static final String LASTITEM = "Separated link";
    private static final String ITEMS_VALUES = String.format("%s,%s,%s", FIRSTITEM, SECONDITEM, LASTITEM);

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider(name = "dropdownsWithOptions")
    public static Object[][] dropdownsWithOptions() {
        return new Object[][] {
                {offsetDropdown},
                {referenceDropdown}
        };
    }

    @Test(dataProvider = "dropdownsWithOptions")
    public void baseValidationTest(Dropdown dropdown) {
        baseValidation(dropdown);
        dropdown.dropdownToggle.click();
        baseValidation(dropdown.dropdownToggle);
        baseValidation(dropdown.dropdownMenu);
    }

    @Test(dataProvider = "dropdownsWithOptions")
    public void getTextTest(Dropdown dropdown) {
        assertThat(dropdown.getText(), is(DROPDOWN));
    }

    @Test(dataProvider = "dropdownsWithOptions")
    public void getValueTest(Dropdown dropdown) {
        assertThat(dropdown.getValue(), is(DROPDOWN));
    }

    @Test(dataProvider = "dropdownsWithOptions")
    public void itemsTest(Dropdown dropdown) {
        assertThat(dropdown.items.getValue(), is(ITEMS_VALUES));
    }

    @Test(dataProvider = "dropdownsWithOptions")
    public void clickTest(Dropdown dropdown) {
        dropdown.click();
        dropdown.items.is().displayed();
        assertThat(dropdown.items.isDisplayed(), is(Boolean.TRUE));
    }

    @Test(dataProvider = "dropdownsWithOptions")
    public void toggleTest(Dropdown dropdown) {
        dropdown.dropdownToggle.click();
        dropdown.items.is().displayed();
        assertThat(dropdown.items.isDisplayed(), is(Boolean.TRUE));
    }
}
