package com.mayzhou.runtimeAnnotations.excelkit.converter;

import com.mayzhou.runtimeAnnotations.excelkit.convert.ReadConverter;
import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitReadConverterException;

/**
 * @author MayZhou
 */
public class CustomizeFieldReadConverter implements ReadConverter {
    /**
     * 将value转换成指定的值, 读取时映射到实体中
     *
     * @param value 当前单元格的值
     * @return 转换后的值
     */
    @Override
    public Object convert(Object value) throws ExcelKitReadConverterException {
        return null;
    }
}
