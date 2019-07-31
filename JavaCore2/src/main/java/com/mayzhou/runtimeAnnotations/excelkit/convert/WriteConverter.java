package com.mayzhou.runtimeAnnotations.excelkit.convert;


import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitWriteConverterException;

/**
 * @author wuwenze
 */
public interface WriteConverter {

  /**
   * 将value转换成指定的值, 用于写入excel表格中
   *
   * @param value 当前单元格的值
   * @return 转换后的值
   */
  String convert(Object value) throws ExcelKitWriteConverterException;
}
