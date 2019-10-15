package io.github.com.sections.form;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

/**
 * Created by Roman Bordiugov on 10.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormControlsFileInput extends Form {

    @UI("#exampleFormControlFile1")
    public UIElement fileInput;
}
