package com.mayzhou.runtimeAnnotations.excelkit.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 公共字段
 *
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Const {
    /**
     * 编码
     */
    public static final String ENCODING = "UTF-8";
    /**
     * Excel后缀
     */
    public static final String XLSX_SUFFIX = ".xlsx";
    /**
     * HTTP
     * MIME(Multipurpose Internet Mail Extensions)多用途互联网邮件扩展类型
     */
    public static final String XLSX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    /**
     * MIME 协议的扩展
     * 可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名
     */
    public static final String XLSX_HEADER_KEY = "Content-disposition";
    /**
     * Response.AppendHeader("Content-Disposition","attachment;filename=FileName.txt");
     */
    public static final String XLSX_HEADER_VALUE_TEMPLATE = "attachment; filename=%s";
    public static final String XLSX_DEFAULT_EMPTY_CELL_VALUE = "$EMPTY_CELL$";
    public static final Integer XLSX_DEFAULT_BEGIN_READ_ROW_INDEX = 1;
    /**
     * 默认xml解析器
     */
    public static final String SAX_PARSER_CLASS = "org.apache.xerces.parsers.SAXParser";
    public static final String SAX_C_ELEMENT = "c";
    public static final String SAX_R_ATTR = "r";
    public static final String SAX_T_ELEMENT = "t";
    public static final String SAX_S_ATTR_VALUE = "s";
    public static final String SAX_RID_PREFIX = "rId";
    public static final String SAX_ROW_ELEMENT = "row";

    /**
     * 中国区日期格式
     */
    public final static SimpleDateFormat CHINESE_LOCAL_DF = new SimpleDateFormat(
            "yyyy年MM月dd日 HH:mm:ss", Locale.CHINESE);

    /**
     * 英语区日期格式
     */
    public final static SimpleDateFormat ENGLISH_LOCAL_DF = new SimpleDateFormat(
            "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
}
