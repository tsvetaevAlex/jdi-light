package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static com.epam.jdi.light.elements.init.PageFactory.PRE_INIT;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 * <p>
 * Selenium PageFactory
 */

public class PageFactory {

    /**
     * Initializes all sites in your class (fields maybe with annotation @Url or @Title, class must be with annotation @JSite)
     * @param site A class which will be initialised.
     * @param driverName The driver that will be used to look up the elements
     */
    public static void initSite(Class<?> site, String driverName) {
        PRE_INIT = HtmlSettings::init;
        com.epam.jdi.light.elements.init.PageFactory.initSite(site, driverName);
    }

    /**
     * As {@link #initSite(Class, String)}
     * @param site A class which will be initialised.
     */
    public static void initSite(Class<?> site) {
        PRE_INIT = HtmlSettings::init;
        com.epam.jdi.light.elements.init.PageFactory.initSite(site);
    }

    /**
     * As {@link #initSite(Class, String)}
     * @param site A class which will be initialised.
     * @param driver The driver that will be used to look up the elements
     */
    public static void initElements(Class<?> site, JFunc<WebDriver> driver) {
        String driverName = WebDriverFactory.useDriver(driver);
        initSite(site, driverName);
    }

    /**
     *  As {@link #initSite(Class, String)}
     * @param site A class which will be initialised.
     */
    public static void initElements(Class<?> site) {
        initSite(site);
    }
    public static void initElements(JFunc<WebDriver> driver, Object... pages) { }

    /**
     * As {@link #initElements(WebDriver, Class)} but for several classes
     * @param pages A classes which will be initialised.
     */
    public static void initElements(Class<?>... pages) {
        for (Class<?> page : pages) {
            initElements((WebDriver) null, page);
        }
    }

    /**
     * As {@link #initElements(WebDriver, Class)} but will only replace the fields of an already instantiated  Page Objects
     */
    public static void initElements(Object... pages) {
        PRE_INIT = HtmlSettings::init;
        com.epam.jdi.light.elements.init.PageFactory.initElements(pages);
    }

    // Selenium PageFactory
    /**
     * Instantiate an instance of the given class, and set a lazy proxy for each of the WebElement and
     * List<WebElement> ; fields that have been declared, assuming that the field
     * name is also the HTML element's "id" or "name". This means that for the class:
     *
     * <code> public class Page { private WebElement submit; } </code>
     *
     * there will be an element that can be located using the xpath expression "//*[@id='submit']" or
     * "//*[@name='submit']"
     *
     * By default, the element or the list is looked up each and every time a method is called upon
     * it.
     *
     * This method will attempt to instantiate the class given to it, preferably using a constructor
     * which takes a WebDriver instance as its only argument or falling back on a no-arg constructor.
     * An exception will be thrown if the class cannot be instantiated.
     *
     * @param driver The driver that will be used to look up the elements
     * @param pageClassToProxy A class which will be initialised.
     * @param <T> - Class of the PageObject
     * @return An instantiated instance of the class with WebElement and List<WebElement> fields proxied
     */
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        PRE_INIT = HtmlSettings::init;
        return com.epam.jdi.light.elements.init.PageFactory.initElements(driver, pageClassToProxy);
    }

    /**
     * As {@link #initElements(WebDriver, Class)} but will only replace the fields of an already instantiated Page Object.
     */
    public static void initElements(WebDriver driver, Object page) {
        initElements(page);
    }

    /**
     * Similar to the other {@link #initElements(WebDriver, Class)} methods, but takes an ElementLocatorFactory which is used for providing the mechanism for finding elements. If the ElementLocatorFactory returns null then the field won't be decorated.
     */
    public static void initElements(ElementLocatorFactory factory, Object page) {
        initElements(page);
    }

    /**
     * Similar to the other {@link #initElements(WebDriver, Class)} methods, but takes an FieldDecorator which is used for decorating each of the fields.
     */
    public static void initElements(FieldDecorator decorator, Object page) {
        initElements(page);
    }
}