package com.mayzhou.runtimeAnnotations.excelkit.pojo;

import com.mayzhou.runtimeAnnotations.excelkit.config.Options;
import com.mayzhou.runtimeAnnotations.excelkit.convert.ReadConverter;
import com.mayzhou.runtimeAnnotations.excelkit.convert.WriteConverter;
import com.mayzhou.runtimeAnnotations.excelkit.validator.Validator;
import lombok.*;

/**
 * @author MayZhou
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExcelProperty {

    private String name;
    private String column;
    private Boolean required;
    private Short width;
    private String comment;
    private Integer maxLength;
    private String dateFormat;
    /**
     * 下拉框
     */
    private Options options;
    private String writeConverterExp;
    private WriteConverter writeConverter;
    private String readConverterExp;
    private ReadConverter readConverter;
    private String regularExp;
    private String regularExpMessage;
    private Validator validator;
}
