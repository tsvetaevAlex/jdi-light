package io.github.epam.html.tests.core;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.common.Checkbox;
import io.github.com.StaticSite;
import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static io.github.com.StaticSite.differentElementsPage;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class LocatorStaticSiteTests extends TestsInit {

    @BeforeMethod
    public void beforeMethod() {
        shouldBeLoggedIn();
        differentElementsPage.shouldBeOpened();
        refresh();
    }

    @Test
    public void seleniumFindByLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindBy);
    }

    @Test
    public void jdiFindByCssLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterJDIFindByCss);
    }

    @Test
    public void jdiFindByTextLocatorTest() {
        differentElementsPage.waterJDIFindByText.assertThat().text(is("Water"));
    }

    @Test
    public void cssLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterCss);
    }

    @Test
    public void xpathFindByLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterXPath);
    }

    @Test
    public void byTextLocatorTest() {
        differentElementsPage.waterByText.assertThat().text(is("Water"));
    }

    @Test
    public void withTextLocatorTest() {
        differentElementsPage.waterWithText.assertThat().text(is("Water"));
    }

    @Test
    public void cssUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUICss);
    }

    @Test
    public void xpathUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIXpath);
    }

    @Test
    public void cssHasTextUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIHasText);
    }

    @Test
    public void cssWithTextUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIWithText);
    }

    @Test
    public void cssWithPositionUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIPosition);
    }

    @Test
    public void uiLocatorMovingUpTheTreeTest() {
        differentElementsPage.waterUIMoveUp.assertThat().text(is("Water"));
    }

    public class LocatorWithGroupStaticSiteTests extends TestsInit {
        private String previousTestGroup;

        @BeforeClass
        public void beforeClass() {
            previousTestGroup = WebSettings.TEST_GROUP;
        }

        @AfterClass
        public void afterClass() {
            WebSettings.TEST_GROUP = previousTestGroup;
            initElements(StaticSite.class);
        }

        @BeforeMethod
        public void beforeMethod() {
            shouldBeLoggedIn();
            differentElementsPage.shouldBeOpened();
            refresh();
        }

        @DataProvider
        public Object[][] groupStaticSiteLocatorDataProvider(){
            return new Object[][]{
                    {differentElementsPage.waterJDIFindByGroupVarying, "", "Earth"},
                    {differentElementsPage.waterJDIFindByGroupVarying, "QC", "Water"},
                    {differentElementsPage.waterJDIFindByGroupVarying, "NotRepresentedInLocators", "Earth"},
                    {differentElementsPage.waterUIGroupVarying, "", "Earth"},
                    {differentElementsPage.waterUIGroupVarying, "QC", "Water"},
                    {differentElementsPage.waterUIGroupVarying, "NotRepresentedInLocators", "Earth"}
            };
        }

        @Test(dataProvider = "groupStaticSiteLocatorDataProvider")
        public void groupsLocatorTest(JDIBase element, String group, String expectedText) {
            WebSettings.TEST_GROUP = group;
            initElements(StaticSite.class);
            element.assertThat().text(is(expectedText));
        }
    }

    @Test
    @Ignore
    //TBD: unignore after functionality is fixed/added, put in independent tests
    public void complexLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindByHowAndUsing);
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindBys);
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterJDIFindBys);
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindAll);
        //checkThatElementIsCorrectlySelected(differentElementsPage.waterJDIFindAll); //TBD
    }

    private static void checkThatCheckboxIsCorrectlySelected(Checkbox checkbox) {
        checkbox.check();
        checkbox.is().selected();
    }
}
