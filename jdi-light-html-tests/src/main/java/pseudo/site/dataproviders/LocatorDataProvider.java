package pseudo.site.dataproviders;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSite.locatorsSection;
import static pseudo.site.sections.LocatorsSection.*;

public class LocatorDataProvider {
    @DataProvider
    public Object[][] locatorDataProvider() {
        return new Object[][]{
                //{locatorsSection.seleniumFindByHowAndUsingElement, ""},
                {locatorsSection.seleniumFindByIdElement, "By.id: " + ELEMENT_ID},
                {locatorsSection.seleniumFindByCssElement, "By.cssSelector: #" + ELEMENT_ID},
                {locatorsSection.seleniumFindByXPathElement, "By.xpath: //*[@id='" + ELEMENT_ID + "']"},
                //{locatorsSection.seleniumFindBysElement, "TBD"},
                //{locatorsSection.seleniumFindAllElement, "TBD"},
                {locatorsSection.jdiFindByIdElement, "By.id: " + ELEMENT_ID},
                {locatorsSection.jdiFindByNameElement, "By.name: " + ELEMENT_NAME},
                {locatorsSection.jdiFindByClassNameElement, "By.className: " + ELEMENT_CLASS},
                {locatorsSection.jdiFindByCssElement, "By.cssSelector: #" + ELEMENT_ID},
                {locatorsSection.jdiFindByTagNameElement, "By.tagName: " + ELEMENT_TAG},
                {locatorsSection.jdiFindByLinkTextElement, "By.linkText: " + ELEMENT_LINK_TEXT},
                {locatorsSection.jdiFindByPartialLinkTextElement, "By.partialLinkText: " + ELEMENT_PARTIAL_LINK_TEXT},
                {locatorsSection.jdiFindByXPathElement, "By.xpath: //*[@id='" + ELEMENT_ID + "']"},
                {locatorsSection.jdiFindByTextElement, "By.xpath: .//*/text()[normalize-space(.) = \"" + ELEMENT_TEXT + "\"]/parent::*"},
                //{locatorsSection.jdiFindBysElement, "TBD"},
                //{locatorsSection.jdiFindAllElement, "TBD"},
                {locatorsSection.cssElement, "By.cssSelector: #" + ELEMENT_ID},
                {locatorsSection.xpathElement, "By.xpath: //*[@id='" + ELEMENT_ID + "']"},
                {locatorsSection.byTextElement, "By.xpath: .//*/text()[normalize-space(.) = \"" + ELEMENT_TEXT + "\"]/parent::*"},
                {locatorsSection.withTextElement, "By.xpath: .//*/text()[contains(normalize-space(.), \"" + ELEMENT_PARTIAL_TEXT + "\")]/parent::*"},
                {locatorsSection.uiCssElement, "By.cssSelector: #" + ELEMENT_ID},
                {locatorsSection.uiXpathElement, "By.xpath: //*[@id='" + ELEMENT_ID + "']"},
                {locatorsSection.uiHasTextElement, "By.cssSelector: ['" + ELEMENT_TEXT + "']"},
                {locatorsSection.uiWithTextElement, "By.cssSelector: [*'" + ELEMENT_PARTIAL_TEXT + "']"},
                {locatorsSection.uiPositionElement, "By.cssSelector: [class=" + ELEMENT_CLASS + "][1]"},
                {locatorsSection.uiMoveUpElement, "By.cssSelector: #" + ELEMENT_ID + "<['" + ELEMENT_TEXT + "']"},
                {locatorsSection.dropListElement, "By.cssSelector: #" + ELEMENT_ID},
                {locatorsSection.tableElement, "By.cssSelector: #" + ELEMENT_ID}
        };
    }

    @DataProvider
    public Object[][] groupLocatorDataProvider() {
        return new Object[][]{
                {locatorsSection.jdiFindByGroupVaryingElement, "", "By.id: " + ELEMENT_ID_NO_GROUP},
                {locatorsSection.jdiFindByGroupVaryingElement, ELEMENT_CUSTOM_GROUP, "By.id: " + ELEMENT_ID_CUSTOM_GROUP},
                {locatorsSection.jdiFindByGroupVaryingElement, "NotRepresentedInLocators", "By.id: " + ELEMENT_ID_NO_GROUP},
                {locatorsSection.uiGroupVaryingElement, "", "By.cssSelector: #" + ELEMENT_ID_NO_GROUP},
                {locatorsSection.uiGroupVaryingElement, ELEMENT_CUSTOM_GROUP, "By.cssSelector: #" + ELEMENT_ID_CUSTOM_GROUP},
                {locatorsSection.uiGroupVaryingElement, "NotRepresentedInLocators", "By.cssSelector: #" + ELEMENT_ID_NO_GROUP}
        };
    }
}
