package com.mayzhou.runtimeAnnotations.excelkit.config;

/**
 * 用于导出excel
 * @author MayZhou
 */
public interface Options {
    /**
     * 指定excel单元格的下拉框数据源, 用于规范生成Excel模板的数据校验
     *
     * @return ["option1", "option2"]
     */
    String[] get();
}
