package com.mayzhou.runtimeAnnotations.excelkit.entity;

import com.mayzhou.runtimeAnnotations.excelkit.annotation.Excel;
import com.mayzhou.runtimeAnnotations.excelkit.annotation.ExcelField;
import com.mayzhou.runtimeAnnotations.excelkit.converter.CustomizeFieldReadConverter;
import com.mayzhou.runtimeAnnotations.excelkit.converter.CustomizeFieldWriteConverter;
import com.mayzhou.runtimeAnnotations.excelkit.options.SexOptions;
import com.mayzhou.runtimeAnnotations.excelkit.options.UserGroupNameOptions;
import com.mayzhou.runtimeAnnotations.excelkit.validator.UserEmailValidator;
import com.mayzhou.runtimeAnnotations.excelkit.validator.UserNameValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author MayZhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Excel("用户信息")
public class User {
    @ExcelField(value = "编号", width = 30)
    private Integer userId;
    @ExcelField(//
            value = "用户名",//
            required = true,//
            validator = UserNameValidator.class,//
            comment = "请填写用户名，最大长度为12，且不能重复"
    )
    private String username;
    @ExcelField(value = "密码", required = true, maxLength = 32)
    private String password;
    @ExcelField(value = "邮箱", validator = UserEmailValidator.class)
    private String email;
    @ExcelField(//
            value = "性别",//
            readConverterExp = "未知=0,男=1,女=2",//
            writeConverterExp = "0=未知,1=男,2=女",//
            options = SexOptions.class//
    )
    private Integer sex;
    @ExcelField(//
            value = "用户组",//
            name = "userGroup.name",//
            options = UserGroupNameOptions.class
    )
    private UserGroup userGroup;
    @ExcelField(value = "创建时间", dateFormat = "yyyy/MM/dd HH:mm:ss")
    private Date createAt;
    @ExcelField(//
            value = "自定义字段",//
            maxLength = 80,//
            comment = "可以乱填，但是长度不能超过80，导入时最终会转换为数字",//
            writeConverter = CustomizeFieldWriteConverter.class,// 写文件时，将数字转字符串
            readConverter = CustomizeFieldReadConverter.class// 读文件时，将字符串转数字
    )
    private Integer customizeField;
}
