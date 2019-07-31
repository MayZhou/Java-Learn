package com.mayzhou.runtimeAnnotations.excelkit.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MayZhou
 */
public class UserNameValidator implements Validator {
    /**
     * 验证单元格的值, 若验证失败, 请返回错误消息.
     *
     * @param value 当前单元格的值
     * @return null or errorMessage
     */
    @Override
    public String valid(Object value) {
        if (value != null) {
            Pattern pattern = Pattern.compile("[0-9]*");
            String userName = (String)value;
            Matcher isNum = pattern.matcher(userName.charAt(0) + "");
            if (isNum.matches()) {
                return "[" + userName + "]姓名不能以数字开头.";
            } else {
                return null;
            }
        }
        return "姓名不能为空";
    }
}
