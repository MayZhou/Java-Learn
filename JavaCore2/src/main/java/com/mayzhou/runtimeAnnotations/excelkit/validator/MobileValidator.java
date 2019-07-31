package com.mayzhou.runtimeAnnotations.excelkit.validator;

import com.mayzhou.runtimeAnnotations.excelkit.util.ValidatorUtil;

/**
 * @author MayZhou
 */
public class MobileValidator implements Validator {
    /**
     * 验证单元格的值, 若验证失败, 请返回错误消息.
     *
     * @param value 当前单元格的值
     * @return null or errorMessage
     */
    @Override
    public String valid(Object value) {
        String valueString = (String) value;
        return ValidatorUtil.isMobile(valueString) ? null : "[" + valueString + "]不是正确的手机号码.";
    }
}
