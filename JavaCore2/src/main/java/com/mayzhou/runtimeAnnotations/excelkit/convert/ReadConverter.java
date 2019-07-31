package com.mayzhou.runtimeAnnotations.excelkit.convert;

import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitReadConverterException;

/**
 * @author MayZhou
 */
public interface ReadConverter {
    /**
     * 将value转换成指定的值, 读取时映射到实体中
     *
     * @param value 当前单元格的值
     * @return 转换后的值
     */
    Object convert(Object value) throws ExcelKitReadConverterException;
}
