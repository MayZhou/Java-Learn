package com.mayzhou.runtimeAnnotations.excelkit.validator;

import com.mayzhou.runtimeAnnotations.excelkit.util.ValidatorUtil;

/**
 * @author MayZhou
 */
public class EmailValidator implements Validator {

    @Override
    public String valid(Object value) {
        String valueString = (String) value;
        return ValidatorUtil.isEmail(valueString) ? null : "[" + valueString + "]不是正确的EMail.";
    }
}
