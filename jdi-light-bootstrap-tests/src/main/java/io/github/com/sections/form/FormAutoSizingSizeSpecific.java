package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormAutoSizingSizeSpecific extends Section {

    @UI("#inlineFormInputName")
    public TextField name;
    @UI(".input-group-text")
    public TextField atSign;
    @UI("//input[@id='inlineFormInputName']/..")
    public Text colParameterName;
    @UI("#inlineFormInputGroupUsername")
    public TextField email;
    @UI("//label[@for='inlineFormInputGroupUsername']/..")
    public Text colParameterEmail;
    @UI("#autoSizingCheck2")
    public Checkbox rememberMeCheckbox;
    @UI("//input[@id='autoSizingCheck2']/../..")
    public Text colParameterCheckbox;
    @UI("button")
    public Button submit;
    @UI("//button/..")
    public Button colParameterButton;

}