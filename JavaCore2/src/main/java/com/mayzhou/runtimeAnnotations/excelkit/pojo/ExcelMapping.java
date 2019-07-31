package com.mayzhou.runtimeAnnotations.excelkit.pojo;

import lombok.*;

import java.util.List;

/**
 * 配置Excel与实体之间的映射关系
 * @author MayZhou
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExcelMapping {

    private String name;
    private List<ExcelProperty> propertyList;

}
