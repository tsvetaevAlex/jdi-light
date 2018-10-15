package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.HasValue;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public interface BaseElement extends HasValue {

    @JDIAction
    void hover();

    @JDIAction
    boolean isEnabled();

    @JDIAction
    boolean isDisplayed();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();
    <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException;
    String getAttribute(String name);
    void setAttribute(String name, String value);
    void higlight(String color);

    @JDIAction
    void higlight();

    @JDIAction
    void show();

    @JDIAction
    Select select();

    default UIElement base() {return (UIElement) this; }
}
