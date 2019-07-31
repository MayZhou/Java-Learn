package com.mayzhou.runtimeAnnotations.excelkit.pojo;


import lombok.*;

/**
 * @author MayZhou
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExcelErrorField {

    private Integer cellIndex;
    private String name;
    private String column;
    private String errorMessage;
}
