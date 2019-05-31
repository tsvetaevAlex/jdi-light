package pseudo.site.sections;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Root;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.*;
import org.openqa.selenium.support.How;

public class LocatorsSection extends Section {
    public static final String ELEMENT_ID = "id";
    public static final String ELEMENT_ID_NO_GROUP = "id";
    public static final String ELEMENT_ID_CUSTOM_GROUP = "custom-id";
    public static final String ELEMENT_CLASS = "class";
    public static final String ELEMENT_NAME = "name";
    public static final String ELEMENT_TAG = "div";
    public static final String ELEMENT_LINK_TEXT = "text";
    public static final String ELEMENT_PARTIAL_LINK_TEXT = "tex";
    public static final String ELEMENT_TEXT = "text";
    public static final String ELEMENT_PARTIAL_TEXT = "tex";
    public static final String ELEMENT_CUSTOM_GROUP = "CustomGroup";

    @org.openqa.selenium.support.FindBy(how = How.ID, using = ELEMENT_ID)
    public JDIBase seleniumFindByHowAndUsingElement;

    @org.openqa.selenium.support.FindBy(id = ELEMENT_ID)
    public JDIBase seleniumFindByIdElement;

    @org.openqa.selenium.support.FindBy(css = "#" + ELEMENT_ID)
    public JDIBase seleniumFindByCssElement;

    @org.openqa.selenium.support.FindBy(xpath = "//*[@id='" + ELEMENT_ID + "']")
    public JDIBase seleniumFindByXPathElement;

    @org.openqa.selenium.support.FindBys({
            @org.openqa.selenium.support.FindBy(css = "#" + ELEMENT_ID + "1"),
            @org.openqa.selenium.support.FindBy(css = "#" + ELEMENT_ID + "2")
    })
    public JDIBase seleniumFindBysElement;

    @org.openqa.selenium.support.FindAll({
            @org.openqa.selenium.support.FindBy(css = "." + ELEMENT_CLASS + "1"),
            @org.openqa.selenium.support.FindBy(css = "." + ELEMENT_CLASS + "2")
    })
    public JDIBase seleniumFindAllElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(id = ELEMENT_ID)
    public JDIBase jdiFindByIdElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(name = ELEMENT_NAME)
    public JDIBase jdiFindByNameElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(className = ELEMENT_CLASS)
    public JDIBase jdiFindByClassNameElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "#" + ELEMENT_ID)
    public JDIBase jdiFindByCssElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(tagName = ELEMENT_TAG)
    public JDIBase jdiFindByTagNameElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(linkText = ELEMENT_LINK_TEXT)
    public JDIBase jdiFindByLinkTextElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(partialLinkText = ELEMENT_PARTIAL_LINK_TEXT)
    public JDIBase jdiFindByPartialLinkTextElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(xpath = "//*[@id='" + ELEMENT_ID + "']")
    public JDIBase jdiFindByXPathElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(text = "text")
    public JDIBase jdiFindByTextElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBys({
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "#" + ELEMENT_ID + "1"),
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "#" + ELEMENT_ID + "2")
    })
    public JDIBase jdiFindBysElement;

    /* TBD
    @com.epam.jdi.light.elements.pageobjects.annotations.FindAll({
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "." + ELEMENT_CLASS + "1"),
            @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "." + ELEMENT_CLASS + "2")
    })
    public JDIBase jdiFindAllElement;*/

    @Css("#" + ELEMENT_ID)
    public JDIBase cssElement;

    @XPath("//*[@id='" + ELEMENT_ID + "']")
    public JDIBase xpathElement;

    @ByText(ELEMENT_TEXT)
    public JDIBase byTextElement;

    @WithText(ELEMENT_PARTIAL_TEXT)
    public JDIBase withTextElement;

    @UI("#" + ELEMENT_ID)
    public JDIBase uiCssElement;

    @UI("//*[@id='" + ELEMENT_ID + "']")
    public JDIBase uiXpathElement;

    @UI("['" + ELEMENT_TEXT + "']")
    public JDIBase uiHasTextElement;

    @UI("[*'" + ELEMENT_PARTIAL_TEXT + "']")
    public JDIBase uiWithTextElement;

    @UI("[class=" + ELEMENT_CLASS + "][1]")
    public JDIBase uiPositionElement;

    @UI("#" + ELEMENT_ID + "<['" + ELEMENT_TEXT + "']")
    public JDIBase uiMoveUpElement;

    @Root
    @UI("#" + ELEMENT_ID)
    public JDIBase rootElement;

    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(id = ELEMENT_ID_CUSTOM_GROUP, group = ELEMENT_CUSTOM_GROUP)
    @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(id = ELEMENT_ID_NO_GROUP)
    public JDIBase jdiFindByGroupVaryingElement;

    @UI(value = "#" + ELEMENT_ID_CUSTOM_GROUP, group = ELEMENT_CUSTOM_GROUP)
    @UI("#" + ELEMENT_ID_NO_GROUP)
    public JDIBase uiGroupVaryingElement;

    @JDropdown(
            root = "#" + ELEMENT_ID,
            value = "input",
            list = "li",
            expand = ".expand"
    )
    public Droplist dropListElement;

    @JTable(
            root = "#" + ELEMENT_ID,
            header = {"Name", "Phone", "Email", "City"},
            headers = "th",
            row = "//tr[%s]/td",
            column = "//tr/td[%s]",
            cell = "//tr[{1}]/td[{0}]",
            allCells = "td",
            rowHeader = "Name",
            size = 3,
            count = 5,
            firstColumnIndex = -1,
            columnsMapping = {3, 1, 2}
    )
    public Table tableElement;

}
