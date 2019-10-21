package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.com.pages.BootstrapPage.formGrid;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class FormGridTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] layoutData() {
        return new Object[][]{
                {formGrid.name, "input", "form-control", "text", "First name"},
                {formGrid.lastName, "input", "form-control", "text", "Last name"},
        };
    }

    @Test(dataProvider = "layoutData")
    public void isValidationTests(TextField element, String tagPresent, String classPresent,
                                  String type, String placeHolder) {
        element.highlight();
        element
                .is()
                .enabled()
                .displayed()
                .core()
                .tag(is(tagPresent))
                .hasClass(classPresent)
                .attr("type", type)
                .attr("placeholder", placeHolder);
        element.unhighlight();
    }

    @Test
    public void fillTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitTextToContactFormTest() {
        formCustomStyles.submit("Roman");
        formCustomStyles.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormTest() {
        formCustomStyles.submit(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formCustomStyles.submit("Roman", "submit");
        formCustomStyles.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        List<String> verified = formCustomStyles.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void verifyMethodNegativeTest() {
        formCustomStyles.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formCustomStyles.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(1));
        jdiAssert(verified.get(0), containsString("Mark"));
    }

    @Test
    public void sendMethodTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.send();
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void sendEntityMethodTest() {
        formCustomStyles.send(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void addEntityMethodTest() {
        formCustomStyles.add(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void publishMethodTest() {
        formCustomStyles.publish(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void saveMethodTest() {
        formCustomStyles.save(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void updateMethodTest() {
        formCustomStyles.update(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void cancelMethodTest() {
        formCustomStyles.cancel(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void closeMethodTest() {
        formCustomStyles.close(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void backMethodTest() {
        formCustomStyles.back(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void selectMethodTest() {
        formCustomStyles.select(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void nextMethodTest() {
        formCustomStyles.next(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void searchMethodTest() {
        formCustomStyles.search(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    private void checkContactFormSubmitted() {
        formCustomStyles.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}
