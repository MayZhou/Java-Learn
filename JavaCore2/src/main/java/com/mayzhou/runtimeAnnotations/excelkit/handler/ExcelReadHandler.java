package com.mayzhou.runtimeAnnotations.excelkit.handler;

import com.mayzhou.runtimeAnnotations.excelkit.pojo.ExcelErrorField;

import java.util.List;

/**
 * @author MayZhou
 */
public interface ExcelReadHandler<T> {

    void onSuccess(int sheetIndex, int rowIndex, T entity);

    void onError(int sheetIndex, int rowIndex, List<ExcelErrorField> errorFieldList);
}
