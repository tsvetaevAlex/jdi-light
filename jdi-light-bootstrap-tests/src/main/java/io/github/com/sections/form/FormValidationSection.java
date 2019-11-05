package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class FormValidationSection extends Section {

    @UI("#browser-validation-radio")
    private RadioButton browserValidationRadio;
    @UI("#client-validation-radio")
    private RadioButton customValidationRadio;

    @UI("#validated-form")
    private FormValidationForm validatedForm;


    public void swithToBrowserValidation() {
        browserValidationRadio.select();
    }

    public void swithToCustomValidation() {
        browserValidationRadio.select();
    }

    public FormValidationForm form() {
        return  validatedForm;
    }

}