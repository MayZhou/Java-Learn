package com.mayzhou.runtimeAnnotations.excelkit.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

/**
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {
    /**
     * 本地缓存
     */
    public static final LoadingCache<String, SimpleDateFormat> mDateFormatLoadingCache = CacheBuilder.newBuilder().maximumSize(5).build(new CacheLoader<String, SimpleDateFormat>() {
        @Override
        public SimpleDateFormat load(String s) throws Exception {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s);

            /**
             * 输入“33/12/2011”，用SimpleDateFormat parse()方法,转化为Date(2012,01,02).这样处理相当“33/12/2011”是正常输入，如果需要"33/12/2011”报错，即把"33/12/2011"当作错误格式，刚开始自己写了段逻辑判断：
             * setLenient用于设置Calendar是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
             */
            simpleDateFormat.setLenient(true);
            return simpleDateFormat;
        }
    });

    /**
     *
     * @param pattern
     * @param value
     * @return
     * @throws Exception
     */
    public static Date parse(String pattern, Object value) throws Exception {
        String valueString = (String) value;
        return DateUtil.mDateFormatLoadingCache.get(pattern).parse(valueString);
    }

    public static String format(String pattern, Date value) {
        try {
            return DateUtil.mDateFormatLoadingCache.get(pattern).format(value);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return value.toString();
    }
}
