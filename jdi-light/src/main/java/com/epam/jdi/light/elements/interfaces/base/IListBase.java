package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IListBase extends IsText, HasClick {
    @JDIAction("Check that '{name}' is selected")
    default boolean isSelected() {
        return core().isSelected();
    }

    @JDIAction("Check that '{name}' is deselected")
    default boolean isDeselected() {
        return core().isDeselected();
    }
}
