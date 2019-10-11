package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextArea;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.form.FormControlsEntity;

/**
 * Created by Roman Bordiugov on 7.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormControls extends Form<FormControlsEntity> { //TODO Parametrize with entity

    @UI("#exampleFormControlInput1")
    public TextField formControlInput;

    @UI("#exampleFormControlSelect1")
    public Dropdown formControlDropdown; //maybe DropdownSelect or Selector

    @UI("#exampleFormControlSelect2")
    public Selector formControlMultiSelect;

    @UI("#exampleFormControlTextarea1")
    public TextArea formControlTextArea;
}
