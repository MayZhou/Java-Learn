package com.mayzhou.runtimeAnnotations.excelkit.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

/**
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegexUtil {
    private final static LoadingCache<String, Pattern> mRegexPatternLoadingCache =
            CacheBuilder.newBuilder()
                    .maximumSize(5)
                    .build(new CacheLoader<String, Pattern>() {

                        @Override
                        public Pattern load(String pattern) {
                            return Pattern.compile(pattern);
                        }
                    });

    /**
     *判断value是否与pattern匹配
     * @param pattern
     * @param value
     * @return
     */
    public static Boolean isMatches(String pattern, Object value) {
        try {
            String valueString = (String) value;
            return RegexUtil.mRegexPatternLoadingCache.get(pattern).matcher(valueString).matches();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}
