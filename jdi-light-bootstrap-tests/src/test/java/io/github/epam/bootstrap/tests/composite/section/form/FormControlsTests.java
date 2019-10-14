package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import io.github.com.entities.form.FormControlsEntity;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.form.FormControlsData.DEFAULT_CONTACT;
import static io.github.com.pages.BootstrapPage.formControls;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Bordiugov on 11.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormControlsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        FormControlsEntity fce = DEFAULT_CONTACT;
        formControls.formControlInput
                .is()
                .displayed()
                .enabled()
                .core()
                .value(fce.mail)
                .hasClass("form-control")
                .attr("type", "email")
                .attr("placeholder", "name@example.com")
                .tag(is("input"));
        checkElementLabel(formControls.formControlInput);
        formControls.formControlDropdown
                .is()
                .displayed()
                .enabled()
                .core()
                //.value("1")
                .hasClass("form-control")
                .tag(is("select"));
        checkElementLabel(formControls.formControlDropdown);
        formControls.formControlMultiSelect
                .is()
                .displayed()
                .enabled()
                .core()
                //.value(fce.numberSelected)
                .hasClass("form-control")
                .attr("multiple", "true")
                .tag(is("select"));
        checkElementLabel(formControls.formControlMultiSelect);
        formControls.formControlTextArea
                .is()
                .displayed()
                .enabled()
                .core()
                .value(fce.textArea)
                .hasClass("form-control")
                .attr("rows", "3")
                .tag(is("textarea"));
        checkElementLabel(formControls.formControlTextArea);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formControls.formControlInput);
        baseValidation(formControls.formControlDropdown);
        baseValidation(formControls.formControlMultiSelect);
        baseValidation(formControls.formControlTextArea);
    }

    private void checkElementLabel(HasLabel element) {
        element.label()
                .is()
                .enabled()
                .and()
                .displayed();
    }
}
