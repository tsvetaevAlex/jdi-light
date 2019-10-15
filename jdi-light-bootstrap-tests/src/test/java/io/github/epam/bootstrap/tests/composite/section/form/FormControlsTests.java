package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import io.github.com.entities.form.FormControlsEntity;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
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

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {new FormControlsEntity().set(c -> {
                    c.mail = "";
                    c.numberSelected = "1";
                    c.numbersMultiSelect = null;
                    c.textArea = "";
                })},
                {new FormControlsEntity().set(c -> {
                    c.mail = "alpino@mail.org";
                    c.numberSelected = "2";
                    c.numbersMultiSelect = "3;5";
                    c.textArea = "This is test text for text testing in text area test";
                })}
        };
    }

    @Test(dataProvider = "listData")
    public void formTest(FormControlsEntity entity) {
        formControls.fill(entity);
        formControls.check(entity);
    }

    @Test
    public void isValidationTests() {

        formControls.mail
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "email")
                .attr("placeholder", "name@example.com")
                .tag(is("input"));
        checkElementLabel(formControls.mail);
        formControls.numberSelected
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .tag(is("select"));
        checkElementLabel(formControls.numberSelected);
        formControls.numbersMultiSelect
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("multiple", "true")
                .tag(is("select"));
        checkElementLabel(formControls.numbersMultiSelect);
        formControls.textArea
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("rows", "3")
                .tag(is("textarea"));
        checkElementLabel(formControls.textArea);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formControls.mail);
        baseValidation(formControls.numberSelected);
        baseValidation(formControls.numbersMultiSelect);
        baseValidation(formControls.textArea);
    }

    private void checkElementLabel(HasLabel element) {
        element.label()
                .is()
                .displayed()
                .enabled();
    }
}
