package com.mayzhou.runtimeAnnotations.excelkit.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PathUtil {
    public static String getClasspath() {
        /**
         * getResource接受一个字符串参数，如果以”/”开头，就在classpath根目录下找（不会递归查找子目录），如果不以”/”开头，就在调用getResource的字节码对象所在目录下找（同样不会递归查找子目录）。
         */
        return PathUtil.class.getResource("/").getPath();
    }

    public static String getFilePathByClasspath(String name) {
        return PathUtil.getClasspath() + name;
    }

    public static File getFileByClasspath(String name) {
        return new File(PathUtil.getFilePathByClasspath(name));
    }
}
