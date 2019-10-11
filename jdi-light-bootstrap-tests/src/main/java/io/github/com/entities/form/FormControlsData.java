package io.github.com.entities.form;

import java.util.ArrayList;

/**
 * Created by Roman Bordiugov on 7.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormControlsData {

    public static FormControlsEntity DEFAULT_CONTACT = defaultContact();

    private static FormControlsEntity defaultContact() {
        return new FormControlsEntity().set(c -> {
            c.mail = "";
            c.numberSelected = "3";
            c.numbersMultiSelect = new ArrayList<>();
            c.textArea = "";
        });
    }
}
