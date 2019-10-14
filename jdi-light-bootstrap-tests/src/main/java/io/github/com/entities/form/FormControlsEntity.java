package io.github.com.entities.form;

import com.epam.jdi.tools.DataClass;

import java.util.List;

/**
 * Created by Roman Bordiugov on 11.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormControlsEntity extends DataClass<FormControlsEntity> {

    public String mail;
    public String numberSelected;
    public List numbersMultiSelect;
    public String textArea;
}
