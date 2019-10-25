package io.github.com.sections.listgroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class ListGroupFlush extends Section {

    @UI("li")
    public ListGroup listGroup;

}