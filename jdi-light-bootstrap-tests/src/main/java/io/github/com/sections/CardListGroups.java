package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardListGroups extends Section {

    @UI(".card-header") public Label cardHeader;
    @UI(".list-group-item") public List<WebElement> listGroups;
}