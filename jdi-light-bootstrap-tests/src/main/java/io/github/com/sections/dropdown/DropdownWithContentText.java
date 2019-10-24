package io.github.com.sections.dropdown;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class DropdownWithContentText extends Section {

    @UI(".dropdown-item")
    public WebList items;
    @UI("p")
    public JList<Text> text;
}
