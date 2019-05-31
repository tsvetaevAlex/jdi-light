package io.github.epam.html.tests.core;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.settings.WebSettings;
import io.github.epam.TestsInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pseudo.site.PseudoSite;
import pseudo.site.dataproviders.LocatorDataProvider;

import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pseudo.site.PseudoSite.iframe;
import static pseudo.site.PseudoSite.locatorsSection;
import static pseudo.site.sections.LocatorsSection.ELEMENT_ID;

public class LocatorPseudoSiteTests extends TestsInit {

    @Test(dataProvider = "locatorDataProvider", dataProviderClass = LocatorDataProvider.class)
    public void locatorToByLocatorTest(JDIBase element, String expectedLocator) {
        assertEquals(element.locator.getLocator().toString(), expectedLocator);
    }

    @Test
    public void frameLocatorTest() {
        assertTrue(iframe.locator.isFrame());
        assertEquals(iframe.locator.getLocator().toString(), "By.id: iframe");
    }

    @Test
    public void rootLocatorTest() {
        assertTrue(locatorsSection.rootElement.locator.isRoot());
        assertEquals(locatorsSection.rootElement.locator.getLocator().toString(), "By.cssSelector: #" + ELEMENT_ID);
    }

    @Test
    public void tableLocatorTest(){

    }

    public class LocatorWithGroupPseudoSiteTests extends TestsInit {
        private String previousTestGroup;

        @BeforeClass
        public void beforeClass() {
            previousTestGroup = WebSettings.TEST_GROUP;
        }

        @AfterClass
        public void afterClass() {
            WebSettings.TEST_GROUP = previousTestGroup;
            initElements(PseudoSite.class);
        }

        @Test(dataProvider = "groupLocatorDataProvider", dataProviderClass = LocatorDataProvider.class)
        public void groupsLocatorTest(JDIBase element, String group, String expectedLocator) {
            WebSettings.TEST_GROUP = group;
            initElements(PseudoSite.class);
            assertEquals(element.locator.getLocator().toString(), expectedLocator);
        }
    }

}
