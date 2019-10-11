package io.github.com.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextArea;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;

public class FormControls extends Form { //TODO Parametrize with entity

    @UI("#exampleFormControlInput1")
    public TextField formControlInput;

    @UI("#exampleFormControlSelect1")
    public Dropdown formControlDropdown; //maybe DropdownSelect or Selector

    @UI("#exampleFormControlSelect2")
    public MultiSelector formControlMultiSelect;

    @UI("#exampleFormControlTextarea1")
    public TextArea formControlTextArea;
}
