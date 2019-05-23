package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.base.HtmlList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Roman_Iovlev on 3/28/2018.
 */
public class HtmlFactory {
    /**
     * Returns object of the HtmlElement class that represents first element found by locator on the page
     * @param locator String
     * @return HtmlElement
     */
    public static HtmlElement element(String locator) {
        return element(getLocator(locator));
    }

    /**
     * Returns object of the HtmlElement class that represents first element found by locator of the By class on the page
     * @param byLocator By
     * @return HtmlElement
     */
    public static HtmlElement element(By byLocator) {
        HtmlElement el =  new HtmlElement();
        el.setLocator(byLocator);
        return el;
    }
    private static By getLocator(String locator) {
        return locator.substring(0,2).contains("/")
                ? By.xpath(locator)
                : By.cssSelector(locator);
    }

    /**
     * Returns object of the HtmlElement class that represents first element found by locator on the page
     * @param locator String
     * @return HtmlElement
     */
    public static HtmlElement $(String locator) {
        return element(locator);
    }

    /**
     * Returns object of the HtmlElement class that represents first element found by locator of the By class on the page
     * @param locator By
     * @return HtmlElement
     */
    public static HtmlElement $(By locator) {
        return element(locator);
    }

    /**
     * Returns object of the HtmlElement class that represents first element found by locator from this parent
     * @param locator
     * @param parent
     * @return
     */
    public static HtmlElement $(String locator, Object parent) {
        return element(locator).setParent(parent);
    }

    /**
     * Returns object of the HtmlElement class that represents first element found by locator of the By class from this parent
     * @param locator
     * @param parent
     * @return
     */
    public static HtmlElement $(By locator, Object parent) {
        return element(locator).setParent(parent);
    }

    /**
     * Create new HtmlElement by WebElement
     * @param webElement WebElement
     * @return HtmlElement
     */
    public static HtmlElement $(WebElement webElement) {
        return new HtmlElement(webElement);
    }

    /**
     * Returns object of the HtmlList class that represents all element found by locator on the page
     * @param locator String
     * @return HtmlList
     */
    public static HtmlList list(String locator) {
        return list(getLocator(locator));
    }

    /**
     * Returns object of the HtmlList class that represents all element found by locator of the By class on the page
     * @param byLocator By
     * @return HtmlList
     */
    public static HtmlList list(By byLocator) {
        HtmlList list =  new HtmlList();
        list.setLocator(byLocator);
        return list;
    }

    /**
     * Returns object of the HtmlList class that represents all element found by locator on the page
     * @param locator String
     * @return HtmlList
     */
    public static HtmlList $$(String locator) {
        return list(locator);
    }

    /**
     * Returns object of the HtmlList class that represents all element found by locator of the By class on the page
     * @param locator By
     * @return HtmlList
     */
    public static HtmlList $$(By locator) {
        return list(locator);
    }

    /**
     * Returns object of the HtmlList class that represents all element found by locator of the By class from this parent
     * @param locator
     * @param parent
     * @return
     */
    public static HtmlList $$(By locator, Object parent) {
        return list(locator).setParent(parent);
    }

    /**
     * Returns object of the Droplist class that represents all element found by locator on the page
     * @param locator String
     * @return Droplist
     */
    public static Droplist dropdown(String locator) {
        Droplist el =  new Droplist();
        By byLocator = getLocator(locator);
        el.setLocator(byLocator);
        return el;
    }

    /**
     * Returns object of the Droplist class that represents all element found by locator on the page
     * @param locator String
     * @return Droplist
     */
    public static Droplist $d(String locator) {
        return dropdown(locator);
    }
}
