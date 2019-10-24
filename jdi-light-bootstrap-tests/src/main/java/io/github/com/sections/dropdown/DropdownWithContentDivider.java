package io.github.com.sections.dropdown;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DropdownWithContentDivider extends Section {

    @UI(".dropdown-item")
    public WebList items;
    @UI(".dropdown-divider")
    public UIElement divider;
}
