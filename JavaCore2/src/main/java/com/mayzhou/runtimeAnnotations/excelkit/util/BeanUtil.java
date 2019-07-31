package com.mayzhou.runtimeAnnotations.excelkit.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanUtil extends BeanUtils {
    /**
     * 设置指定的属性值，根据需要执行类型转换，以符合目标属性的类型。
     * @param bean 要在其上执行设置的Bean
     * @param name 属性名(可以嵌套/索引/映射/组合)
     * @param value 要设置的值
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     */
    public static void setComplexProperty(Object bean, String name, Object value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        /**
         * {@link BeanUtils}不支持日期类型的转换
         * BeanUtils.copyProperties() 方法在处理数据类型为日期的属性的值的时候，如果值为空的情况下，判断不出源数据的类型，所以会抛出异常。
         * 修复日期为空时bug
         */
        ConvertUtils.register(new DateConverter(null), Date.class);

        /**
         * 属性名, 仅在复杂数据类型时配置.
         * <pre>
         *     (At)ExcelField(name = "user.name");
         *     private User user;
         * </pre>
         */
        if (!name.contains(".")) {
            BeanUtil.setProperty(bean, name, value);
            return;
        }

        //如果是复杂数据类型

        /**
         * 使用Java反射api来促进Java对象上的通用属性getter和setter操作的实用方法。这些代码的大部分最初都包含在BeanUtils中，但是由于涉及的代码数量太多而被分离。
         */
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        String[] propertyLevels = name.split("\\.");
        String parentPropertyName = "";
        for (int i = 0; i < propertyLevels.length; i++) {
            String p = propertyLevels[i];
            parentPropertyName = (parentPropertyName.equals("") ? p : parentPropertyName + "." + p);
            if (i < propertyLevels.length - 1 && propertyUtilsBean.getProperty(bean, parentPropertyName) != null) {
                continue;
            }

            /**
             * 获取数据对象类型
             */
            Class<?> parentClass = propertyUtilsBean.getPropertyType(bean, parentPropertyName);
            if (i < (propertyLevels.length - 1)) {
                BeanUtil.setProperty(bean, parentPropertyName, parentClass.getConstructor().newInstance());
            } else {
                BeanUtil.setProperty(bean,parentPropertyName,parentClass.getConstructor(String.class).newInstance(value));
            }

        }

    }
}
