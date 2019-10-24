package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownWithContentHeader;
import static io.github.com.pages.BootstrapPage.dropdownWithContentDivider;
import static io.github.com.pages.BootstrapPage.dropdownWithContentText;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

public class DropdownContentTests extends TestsInit {

    private String headerText = "DROPDOWN HEADER";
    private int numberOfItemsHeader = 2;
    private int numberOfChildrenHeader = 3;

    private int numberOfItemsDivider = 3;
    private int numberOfChildrenDivider = 4;

    private String text1 = "Some example text that's free-flowing within the dropdown menu.";
    private String text2 = "And this is more example text.";
    private int numberOfItemsText = 0;
    private int numberOfChildrenText = 2;


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseTest() {
        baseValidation(dropdownWithContentHeader);
        dropdownWithContentHeader.unhighlight();
        baseValidation(dropdownWithContentDivider);
        dropdownWithContentDivider.unhighlight();
        baseValidation(dropdownWithContentText);
        dropdownWithContentText.unhighlight();

    }

    @Test
    public void checkHeaderTest() {
        dropdownWithContentHeader.is().displayed();
        dropdownWithContentDivider.childs().is().size(numberOfChildrenHeader);
        dropdownWithContentHeader.items.is()
                .size(numberOfItemsHeader)
                .values(TextTypes.TEXT, not(hasItem(headerText)));
        dropdownWithContentHeader.header.is()
                .displayed()
                .text(headerText)
                .core().tag("h6");
    }

    @Test
    public void checkDividerTest() {
        dropdownWithContentDivider.is().displayed();
        dropdownWithContentDivider.childs().is().size(numberOfChildrenDivider);
        dropdownWithContentDivider.items.is()
                .size(numberOfItemsDivider);
        dropdownWithContentDivider.items.is(not(hasItem(dropdownWithContentDivider.divider)));
        dropdownWithContentDivider.divider.is()
                .displayed()
                .core().tag("div");
    }

    @Test
    public void checkTextTest() {
        dropdownWithContentText.is().displayed();
        dropdownWithContentText.childs().is().size(numberOfChildrenText);
        dropdownWithContentText.items.is()
                .size(numberOfItemsText);
        for (Text t : dropdownWithContentText.text) {
            dropdownWithContentText.items.is().values(TextTypes.TEXT, not(hasItem(t.getText())));
        }
        dropdownWithContentText.text.is().size(numberOfChildrenText - numberOfItemsText).values(TextTypes.TEXT, hasItems(text1, text2));

    }


}
