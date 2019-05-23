package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.ui.html.utils.HtmlUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HtmlAssertion extends IsAssert<HtmlAssertion> implements ImageAssert, TextAssert,
        LinkAssert, TextAreaAssert, ColorAssert, CheckboxAssert, DateTimeAssert,
        RangeAssert, NumberAssert, ProgressAssert, ComboboxAssert {

    HtmlElement html;
    public HtmlAssertion(HtmlElement html) { super(html); this.html = html; }

    /**
     * Custom match src attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' label {0}")
    public HtmlAssertion label(Matcher<String> condition) {
        assertThat(html.labelText(), condition);
        return this;
    }
    /**
     * Custom match src attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' src {0}")
    public HtmlAssertion src(Matcher<String> condition) {
        assertThat(html.src(), condition);
        return this;
    }

    /**
     * Custom match alt attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' alt {0}")
    public HtmlAssertion alt(Matcher<String> condition) {
        assertThat(html.alt(), condition);
        return this;
    }

    /**
     * Custom match href attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' ref {0}")
    public HtmlAssertion ref(Matcher<String> condition) {
        assertThat(html.ref(), condition);
        return this;
    }

    /**
     * Match passed value with html element height
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' height {0}")
    public HtmlAssertion height(Matcher<Integer> condition) {
        assertThat(getInt("height", html), condition);
        return this;
    }

    /**
     * Match passed value with html element width
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' width {0}")
    public HtmlAssertion width(Matcher<Integer> condition) {
        assertThat(getInt("width", html), condition);
        return this;
    }

    /**
     * Match passed value with html element rows count
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' rows count {0}")
    public HtmlAssertion rowsCount(Matcher<Integer> condition) {
        assertThat(html.rows(), condition);
        return this;
    }

    /**
     * Match passed value with html element cols count
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' columns count {0}")
    public HtmlAssertion colsCount(Matcher<Integer> condition) {
        assertThat(html.cols(), condition);
        return this;
    }

    /**
     * Match passed value with html element min length
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' minlength {0}")
    public HtmlAssertion minlength(Matcher<Integer> condition) {
        assertThat(html.minlength(), condition);
        return this;
    }

    /**
     * Match passed value with html element max length
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' maxlength {0}")
    public HtmlAssertion maxlength(Matcher<Integer> condition) {
        assertThat(html.maxlength(), condition);
        return this;
    }

    /**
     * Match passed color with html element color
     * @param color String
     */
    @JDIAction("Assert that '{name}' color is {0}")
    public HtmlAssertion color(String color) {
        assertThat(html.color(), is(color));
        return this;
    }

    /**
     * Match the selected status html element status
     */
    @JDIAction("Assert that '{name}' is selected")
    public HtmlAssertion selected() {
        assertThat(html.isSelected() ? "selected" : "not selected", is("selected"));
        return this;
    }

    /**
     * Match the not selected status  html element status
     */
    @JDIAction("Assert that '{name}' is not selected")
    public HtmlAssertion deselected() {
        assertThat(html.isSelected() ? "selected" : "not selected", is("not selected"));
        return this;
    }

    /**
     * Match passed value with html element double min value
     * @param min to compare
     */
    @JDIAction("Assert that '{name}' minValue {0}")
    public HtmlAssertion minValue(Matcher<Double> min) {
        assertThat(getDouble("min", html), min);
        return this;
    }

    /**
     * Match passed value with html element double max value
     * @param max to compare
     */
    @JDIAction("Assert that '{name}' maxValue {0}")
    public HtmlAssertion maxValue(Matcher<Double> max) {
        assertThat(getDouble("max", html), max);
        return this;
    }

    /**
     * Match passed value with html element step value
     * @param step to compare
     */
    @JDIAction("Assert that '{name}' step {0}")
    public HtmlAssertion stepValue(Matcher<Double> step) {
        assertThat(getDouble("step", html), step);
        return this;
    }

    /**
     * Match passed value with html element placeholder value
     * @param placeholder to compare
     */
    @JDIAction("Assert that '{name}' placeholder {0}")
    public HtmlAssertion placeholder(Matcher<String> placeholder) {
        assertThat(html.placeholder(), placeholder);
        return this;
    }

    /**
     * Match passed value with html element value
     * @param number to compare
     */
    @JDIAction("Assert that '{name}' number {0}")
    public HtmlAssertion number(Matcher<Double> number) {
        assertThat(getDouble("value", html), number);
        return this;
    }

    /**
     * Match passed value with html element float min value
     * @param min to compare
     */
    @JDIAction("Assert that '{name}' min {0}")
    public HtmlAssertion min(Matcher<Float> min) {
        assertThat(getFloat("min", html), min);
        return this;
    }

    /**
     * Match passed value with html element float max value
     * @param max to compare
     */
    @JDIAction("Assert that '{name}' max {0}")
    public HtmlAssertion max(Matcher<Float> max) {
        assertThat(getFloat("max", html), max);
        return this;
    }

    /**
     * Match passed value with html element volume
     * @param volume to compare
     */
    @JDIAction("Assert that '{name}' volume {0}")
    public HtmlAssertion volume(Matcher<Integer> volume) {
        assertThat(getInt("value", html), volume);
        return this;
    }

    /**
     * Match passed value with html element min volume
     * @param min volume to compare
     */
    @JDIAction("Assert that '{name}' min volume {0}")
    public HtmlAssertion minVolume(Matcher<Integer> min) {
        assertThat(getInt("min", html), min);
        return this;
    }

    /**
     * Match passed value with html element max volume
     * @param max volume to compare
     */
    @JDIAction("Assert that '{name}' max volume {0}")
    public HtmlAssertion maxVolume(Matcher<Integer> max) {
        assertThat(getInt("max", html), max);
        return this;
    }

    /**
     * Match passed value with html element step
     * @param step volume to compare
     */
    @JDIAction("Assert that '{name}' step {0}")
    public HtmlAssertion step(Matcher<Integer> step) {
        assertThat(getInt("step", html), step);
        return this;
    }

    /**
     * Match passed value with html element date value
     * @param date volume to compare
     */
    @JDIAction("Assert that '{name}' date {0}")
    public HtmlAssertion date(Matcher<String> date) {
        assertThat(html.value(), date);
        return this;
    }

    /**
     * Match passed value with html element month value
     * @param month volume to compare
     */
    @JDIAction("Assert that '{name}' month {0}")
    public HtmlAssertion month(Matcher<String> month) {
        assertThat(html.value(), month);
        return this;
    }

    /**
     * Match passed value with html element week value
     * @param week volume to compare
     */
    @JDIAction("Assert that '{name}' week {0}")
    public HtmlAssertion week(Matcher<String> week) {
        assertThat(html.value(), week);
        return this;
    }

    /**
     * Match passed value with html element time value
     * @param time volume to compare
     */
    @JDIAction("Assert that '{name}' time {0}")
    public HtmlAssertion time(Matcher<String> time) {
        assertThat(html.value(), time);
        return this;
    }
}
