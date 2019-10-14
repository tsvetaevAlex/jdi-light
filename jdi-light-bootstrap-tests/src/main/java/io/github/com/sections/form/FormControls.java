package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextArea;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.complex.MultiSelector;
import io.github.com.entities.form.FormControlsEntity;

/**
 * Created by Roman Bordiugov on 10.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormControls extends Form<FormControlsEntity> {

    @UI("#exampleFormControlInput1")
    public TextField formControlInput;

    @UI("#exampleFormControlSelect1")
    public DropdownSelect formControlDropdown;

    @UI("#exampleFormControlSelect2")
    public MultiSelector formControlMultiSelect;

    @UI("#exampleFormControlTextarea1")
    public TextArea formControlTextArea;
}
