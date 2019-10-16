package io.github.epam.bootstrap.tests.composite.section.navbarbrand;

/*
1. @UI / @FindBy annotation cannot find Elements that extends UIBaseElement on web page since
it is required IListBase implemented

2. @After IListBase interface implementation forEach loop does not take first element found
i.e. it does not use 0 index
*/

import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import io.github.epam.TestsInit;
import io.github.epam.bootstrap.tests.BaseValidations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSection;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ForEachUseCaseTest extends TestsInit {

    private List<NavbarBrand> navbarBrandList;
    private String imgPath = "images/wolverin.jpg";
    private String navbarUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    //This is working test
    @Test
    public void baseValidationStreamTest_1() {

        navbarBrandList = new ArrayList<NavbarBrand>();
        for (int i = 1; i <= navbarSection.navbarBrandJList.size(); i++)
            navbarBrandList.add(navbarSection.navbarBrandJList.get(i));

        navbarBrandList.forEach(BaseValidations::baseValidation);
        navbarBrandList.forEach(NavbarBrand::unhighlight);
    }

    //This is NOT working test
    @Test
    public void baseValidationStreamTest_2() {

        navbarSection.navbarBrandJList.forEach(BaseValidations::baseValidation);
        navbarSection.navbarBrandJList.forEach(NavbarBrand::unhighlight);

        navbarSection.navbarBrandJList.forEach( e -> {
            BaseValidations.baseValidation(e);});
    }
}