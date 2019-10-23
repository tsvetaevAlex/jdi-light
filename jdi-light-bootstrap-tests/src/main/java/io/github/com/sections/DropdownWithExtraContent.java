package io.github.com.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class DropdownWithExtraContent extends Section {

    @UI(".dropdown-header") public Text header;
    @UI(".dropdown-divider") public UIElement divider;

    @UI("#dropdown-content-header>*") public WebList items;

}
