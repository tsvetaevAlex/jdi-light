package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.core.ListAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseWebElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.hamcrest.Matchers.greaterThan;

public class JList<T extends BaseWebElement> extends JDIBase
        implements IList<T>, SetValue, ISetup, ISelector, HasAssert<ListAssert> {
    protected CacheValue<List<T>> elements = new CacheValue<>();

    public JList() {}
    public JList(By locator) { setLocator(locator); }
    public JList(List<WebElement> elements) {
        this.elements.setForce(toJList(elements));
    }
    /**
     * @param minAmount
     * @return List
     */
    protected Class<?> initClass = UIElement.class;
    public JList<T> setInitClass(Class<T> listClass) {
        initClass = listClass;
        return this;
    }

    @JDIAction(level = DEBUG)
    public List<T> elements(int minAmount) {
        if (elements.hasValue() && isActual() && elements.get().size() >= minAmount)
            return elements.get();
        if (getLocator().toString().contains("%s"))
            throw exception("You call method that can't be used with template locator. " +
                    "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(getLocator()));
        return this.elements.set(toJList(getList(minAmount)));
    }

    private String NO_ELEMENTS_FOUND = "Can't select '%s'. No elements with this name found";

    /**
     * @param value
     */
    @JDIAction(level = DEBUG)
    public T get(String value) {
        if (getLocator().toString().contains("%s")) {
            T element = getNewInstance(super.get(value)).setName(value);
            element.setGetFunc(() -> super.get(value));
            return element;
        }
        refresh();
        T el = first(e -> e.getText().equals(value));
        if (el == null)
            throw exception(NO_ELEMENTS_FOUND, value);
        el.setName(value);
        el.setGetFunc(() -> first(e -> e.getText().equals(value)));
        return el;
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    /**
     * @param index
     */
    @JDIAction(level = DEBUG)
    public T get(int index) {
        if (index < 0)
            throw exception("Can't get element with index '%s'. Index should be 0 or more", index);
        if (getLocator().toString().contains("%s")) {
            WebElement element;
            try {
                element = super.get(index);
            } catch (Exception ex) {
                throw exception("Can't get element with index '%s' for template locator. " +
                    "Maybe locator is wrong or you need to get element by name. Exception: %s",
                        index, ex.getMessage());
            }
            return getNewInstance(element);
        }
        return elements(index).get(index).setName(format("%s[%s]", getName(), index));
    }

    /**
     * Select the item by the value
     * @param value
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        get(value).click();
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(String... values) {
        for (String value : values)
            select(value);
    }

    /**
     * Select the items by the values, hover and click on them
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String... values) {
        if (ArrayUtils.isEmpty(values))
            throw exception("Nothing to select in %s", getName());
        if (values.length < 2)
            throw exception("Hover and click method should have at list 2 parameters");
        int length = values.length;
        for (int i=0; i < length-1;i++) {
            get(values[i]).hover();
        }
        get(values[length-1]).click();
    }

    /**
     * Select the items by the values, hover and click on them
     * @param value
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String value) {
        String[] split = value.split(">");
        if (split.length == 1)
            select(split[0]);
        else hoverAndClick(split);
    }
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum> void select(TEnum... values) {
        for (TEnum value : values)
            select(value);
    }

    /**
     * Select the item by the index
     * @param index
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        get(index).click();
    }

    /**
     * Select the items by the indexes
     * @param indexes
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }

    /**
     * Get the selected element value
     * @return String
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        refresh();
        T first = logger.logOff(() -> first(BaseWebElement::isSelected) );
        return first != null ? first.getText() : "";
    }

    /**
     * Refresh the element
     */
    @JDIAction(level = DEBUG)
    public void refresh() {
        elements.clear();
    }

    /**
     * Clear the element
     */
    @JDIAction(level = DEBUG)
    public void clear() {
        refresh();
    }

    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return print(values());
    }

    /**
     * Show all items
     */
    @JDIAction
    public void showAll() {
        int size;
        do {
            size = size();
            get(size-1).show();
            clear();
        } while (size < size());
    }


    @Override
    public boolean selected(String option) {
        return get(option).isSelected();
    }

    public List<String> checked() {
        return ifSelect(BaseWebElement::isSelected,
                BaseWebElement::getText);
    }

    public List<String> values() {
        refresh();
        noValidation();
        return map(T::getText);
    }

    public List<String> innerValues() {
        refresh();
        noValidation();
        return map(T::innerText);
    }

    @Override
    public List<String> listEnabled() {
        return ifSelect(JDIBase::isEnabled,
                BaseWebElement::getText);
    }

    @Override
    public List<String> listDisabled() {
        return ifSelect(JDIBase::isDisabled,
                BaseWebElement::getText);
    }
    @Override
    public boolean displayed() {
        return isEmpty() && get(0).displayed();
    }

    @Override @JDIAction(level = DEBUG)
    public void highlight(String color) {
        checkAny("highlight");
        foreach(el -> el.highlight(color));
    }
    @Override @JDIAction(level = DEBUG)
    public void highlight() {
        checkAny("highlight");
        foreach(JDIBase::highlight);
    }
    @Override @JDIAction(level = DEBUG)
    public void hover() {
        checkAny("hover");
        get(0).hover();
    }
    @Override @JDIAction(level = DEBUG)
    public void show() {
        checkAny("show");
        get(0).show();
    }

    private void checkAny(String action) {
        try {
            has().size(greaterThan(0));
        } catch (Exception ex) {
            throw exception("Can't find no '%s' elements. Action '%s' failed", getName(), action);
        }
    }

    //region matchers
    public ListAssert is() {
        return new ListAssert(() -> {refresh(); return this; }, () -> { refresh(); return values(); }, toError());
    }
    @JDIAction("Assert that {name} list meet condition")
    public ListAssert is(Matcher<? super List<T>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public ListAssert assertThat(Matcher<? super List<T>> condition) {
        return is(condition);
    }
    //endregion
    public void setup(Field field) {
        Type[] types;
        try {
            types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        } catch (Exception ex) { return; }
        if (types.length != 1) return;
        try {
            Class<?> initClass = (Class<?>) types[0];
            if (initClass == WebElement.class)
                initClass = UIElement.class;
            setInitClass((Class<T>) initClass);
        } catch (Exception ex) { throw  exception("Can't init WebList. Weblist elements should extend UIElement"); }
    }
    private boolean isActual() {
        try {
            return elements.get().size() > 0 && isNotBlank(elements.get().get(0).getTagName());
        } catch (Exception ex) { return false; }
    }
    private List<T> toJList(List<WebElement> webElements) {
        return LinqUtils.map(webElements, this::getNewInstance);
    }
    private T getNewInstance(WebElement element) {
        try {
            T instance = create(initClass);
            instance.setWebElement(element).setName(getName());
            instance.setTypeName(typeName);
            instance.setParent(parent);
            return instance;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }

    public boolean wait(JFunc1<JList<T>, Boolean> condition) {
        return waitCondition(condition, this);
    }

    public void offCache() {
        super.offCache();
        elements.useCache(false);
    }
}