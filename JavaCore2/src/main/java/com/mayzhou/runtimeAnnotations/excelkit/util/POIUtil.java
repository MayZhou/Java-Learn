package com.mayzhou.runtimeAnnotations.excelkit.util;

import com.mayzhou.runtimeAnnotations.excelkit.config.Options;
import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitRuntimeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class POIUtil {
    private static final int mDefaultRowAccessWindowSize = 100;

    private static SXSSFWorkbook newSXSSFWorkbook(int rowAccessWindowSize) {
        return new SXSSFWorkbook(rowAccessWindowSize);
    }

    public static SXSSFWorkbook newSXSSFWorkbook() {
        return POIUtil.newSXSSFWorkbook(POIUtil.mDefaultRowAccessWindowSize);
    }

    public static SXSSFSheet newSXSSFSheet(SXSSFWorkbook wb, String sheetName) {
        return wb.createSheet(sheetName);
    }

    public static SXSSFRow newSXSSFRow(SXSSFSheet sheet, int index) {
        return sheet.createRow(index);
    }

    public static SXSSFCell newSXSSFCell(SXSSFRow row, int index) {
        return row.createCell(index);
    }

    /**
     * @param sheet SXSSFSheet
     * @param index 第几行
     * @param width 宽度
     * @param value 如果width不合适将使用自适应宽度
     */
    public static void setColumnWidth(SXSSFSheet sheet, int index, Short width, String value) {
        boolean widthNotHaveConfig = (null == width || width == -1);

        if (widthNotHaveConfig && !ValidatorUtil.isEmpty(value)) {
            sheet.setColumnWidth(index, (short) (value.length() * 2048));
        } else {
            width = widthNotHaveConfig ? 200 : width;
            sheet.setColumnWidth(index, (short) (width * 35.7));
        }
    }

    /**
     * 设置下拉框数据
     *
     * @param sheet     SXSSFSheet
     * @param options   下拉框
     * @param firstRow  起始行
     * @param endRow    结束行
     * @param firstCell
     * @param endCell
     */
    public static void setColumnCellRange(SXSSFSheet sheet, Options options, int firstRow, int endRow,
                                          int firstCell, int endCell) {
        if (null != options) {
            String[] dataSource = options.get();
            if (null != dataSource && dataSource.length > 0) {
                /**
                 * 下拉框选项超过了100
                 */
                if (dataSource.length > 100) {
                    throw new ExcelKitRuntimeException("Options item too much.");
                }


                /**
                 *数据有效性验证
                 */
                DataValidationHelper validationHelper = sheet.getDataValidationHelper();
                /**
                 * 设置下拉框数据
                 */
                DataValidationConstraint explicitListConstraint = validationHelper.createExplicitListConstraint(dataSource);
                /**
                 * 设置行列范围
                 */
                CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(firstRow, endRow, firstCell, endCell);
                /**
                 * 有效性数据对象
                 */
                DataValidation validation = validationHelper.createValidation(explicitListConstraint, cellRangeAddressList);
                /**
                 * 抑制下拉箭头
                 */
                validation.setSuppressDropDownArrow(true);
                validation.createErrorBox("提示：", "请从下拉列表选择");
                validation.setShowErrorBox(true);
                sheet.addValidationData(validation);
            }
        }
    }

    public static void write(SXSSFWorkbook wb, OutputStream out) {
        try {
            if (null != null) {
                wb.write(out);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 下载Excel
     *
     * @param wb
     * @param response
     * @param filename
     */
    public static void download(SXSSFWorkbook wb, HttpServletResponse response, String filename) {
        try {
            OutputStream out = response.getOutputStream();
            response.setContentType(Const.XLSX_CONTENT_TYPE);
            response.setHeader(Const.XLSX_HEADER_KEY,
                    String.format(Const.XLSX_HEADER_VALUE_TEMPLATE, filename));
            POIUtil.write(wb, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *正则表达式转换器
     * @param propertyValue
     * @param converterExp
     * @return
     */
    public static Object convertByExp(Object propertyValue, String converterExp) {
        String[] convertSource = converterExp.split(",");
        for (String item : convertSource) {
            String[] itemArray = item.split("=");
            if (itemArray[0].equals(propertyValue)) {
                return itemArray[1];
            }
        }
        return propertyValue;
    }

    /**
     *计算空cell
     * @param ref
     * @param ref2
     * @return
     */
    public static int countNullCell(String ref, String ref2){
        // excel2007最大行数是1048576，最大列数是16384，最后一列列名是XFD
        /**
         * \d匹配一个数字字符。等价于[0-9]
         * +匹配前面的子表达式一次或多次(大于等于1次）
         */
        String xfd = ref.replaceAll("\\d+", "");
        String xfd_1 = ref2.replaceAll("\\d+", "");
        xfd = POIUtil.fillChar(xfd, 3, '@', true);
        xfd_1 = POIUtil.fillChar(xfd_1, 3, '@', true);
        char[] letter = xfd.toCharArray();
        char[] letter_1 = xfd_1.toCharArray();
        int res =
                (letter[0] - letter_1[0]) * 26 * 26 + (letter[1] - letter_1[1]) * 26 + (letter[2]
                        - letter_1[2]);
        return res - 1;
    }

    /**
     * 字符串+char填充
     * @param str
     * @param len
     * @param let
     * @param isPre
     * @return
     */
    private static String fillChar(String str, int len, char let, boolean isPre) {
        int len_1 = str.length();
        if (len_1 < len) {
            if (isPre) {
                for (int i = 0; i < (len - len_1); i++) {
                    str = let + str;
                }
            } else {
                for (int i = 0; i < (len - len_1); i++) {
                    str = str + let;
                }
            }
        }
        return str;
    }

    /**
     * 检查文件合法
     * @param file
     */
    public static void checkExcelFile(File file) {
        String filename = null != file ? file.getAbsolutePath() : null;
        if (null == filename || !file.exists()) {
            throw new ExcelKitRuntimeException("Excel file[" + filename + "] does not exist.");
        }
        if (!filename.endsWith(Const.XLSX_SUFFIX)) {
            throw new ExcelKitRuntimeException(
                    "[" + filename + "]Only .xlsx formatted files are supported.");
        }
    }
}
