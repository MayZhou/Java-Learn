package com.mayzhou.runtimeAnnotations.excelkit.factory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.mayzhou.runtimeAnnotations.excelkit.annotation.Excel;
import com.mayzhou.runtimeAnnotations.excelkit.annotation.ExcelField;
import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitAnnotationAnalyzeException;
import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitConfigAnalyzeFailureException;
import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitConfigFileNotFoundException;
import com.mayzhou.runtimeAnnotations.excelkit.exception.ExcelKitXmlAnalyzeException;
import com.mayzhou.runtimeAnnotations.excelkit.pojo.ExcelMapping;
import com.mayzhou.runtimeAnnotations.excelkit.pojo.ExcelProperty;
import com.mayzhou.runtimeAnnotations.excelkit.util.BeanUtil;
import com.mayzhou.runtimeAnnotations.excelkit.util.PathUtil;
import com.mayzhou.runtimeAnnotations.excelkit.util.ValidatorUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/**
 * @author MayZhou
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelMappingFactory {
    private final static LoadingCache<Class<?>, ExcelMapping> mExcelMappingLoadingCache =
            CacheBuilder.newBuilder()
                    .maximumSize(100)
                    .build(new CacheLoader<Class<?>, ExcelMapping>() {
                        @Override
                        public ExcelMapping load(Class<?> key) {
                            return ExcelMappingFactory.loadExcelMappingByClass(key);
                        }
                    });
    private final static List<String> mClazzFields = Lists
            .newArrayList("options", "writeConverter", "readConverter", "validator");
    private final static List<String> mRequeridAttrs = Lists.newArrayList("name");

    /**
     * 获取指定实体的Excel映射信息
     *
     * @param clazz 实体
     * @return ExcelMapping映射对象
     */
    public static ExcelMapping get(Class<?> clazz) {
        try {
            return ExcelMappingFactory.mExcelMappingLoadingCache.get(clazz);
        } catch (Exception e) {
            throw new ExcelKitConfigAnalyzeFailureException(e);
        }
    }

    private static ExcelMapping loadExcelMappingByClass(Class<?> clazz) {
        // 1. 从配置文件加载 (classpath:excel-mapping/className.xml)
        ExcelMapping excelMapping = null;
        boolean xmlConfigFileNotFound = false;
        String loadExcelMappingFailedMessage = null;
        try {
            excelMapping = ExcelMappingFactory.loadExcelMappingByXml(clazz.getName());
        } catch (Exception e) {
            xmlConfigFileNotFound = e instanceof ExcelKitConfigFileNotFoundException;
            loadExcelMappingFailedMessage = e.getMessage();
        }
        // 2. 从注解加载配置信息 (当配置文件未找到时)
        if (null == excelMapping && xmlConfigFileNotFound) {
            try {
                excelMapping = ExcelMappingFactory.loadExcelMappingByAnnotation(clazz);
            } catch (Exception e) {
                loadExcelMappingFailedMessage = e.getMessage();
            }
        }
        // 3. 加载配置信息失败.
        if (null == excelMapping && null != loadExcelMappingFailedMessage) {
            throw new ExcelKitConfigAnalyzeFailureException(loadExcelMappingFailedMessage);
        }
        return excelMapping;
    }

    /**
     * 通过注解
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static ExcelMapping loadExcelMappingByAnnotation(Class<?> clazz)
            throws IllegalAccessException, InstantiationException {
        ExcelMapping excelMapping = new ExcelMapping();
        Excel excel = clazz.getAnnotation(Excel.class);
        if (null == excel) {
            throw new ExcelKitAnnotationAnalyzeException(
                    "[" + clazz.getName() + "] @Excel annotations not found.");
        }
        excelMapping.setName(excel.value());
        ExcelProperty excelMappingProperty;
        Field[] fields = clazz.getDeclaredFields();
        List<ExcelProperty> propertyList = Lists.newArrayList();
        for (Field field : fields) {
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            if (null != excelField) {
                Class<?> emptyClazz = ExcelField.Void.class;
                excelMappingProperty = ExcelProperty.builder()
                        .name(ValidatorUtil.isEmpty(excelField.name()) ? field.getName() : excelField.name())
                        .required(excelField.required())
                        .column(
                                ValidatorUtil.isEmpty(excelField.value()) ? field.getName() : excelField.value())
                        .comment(excelField.comment())
                        .maxLength(excelField.maxLength())
                        .width(excelField.width())
                        .dateFormat(excelField.dateFormat())
                        .options(excelField.options() != emptyClazz ? excelField.options().newInstance() : null)
                        .writeConverterExp(excelField.writeConverterExp())
                        .writeConverter(excelField.writeConverter() != emptyClazz ? excelField.writeConverter()
                                .newInstance() : null)
                        .readConverterExp(excelField.readConverterExp())
                        .readConverter(
                                excelField.readConverter() != emptyClazz ? excelField.readConverter().newInstance()
                                        : null)
                        .regularExp(excelField.regularExp())
                        .regularExpMessage(excelField.regularExpMessage())
                        .validator(
                                excelField.validator() != emptyClazz ? excelField.validator().newInstance() : null)
                        .build();
                propertyList.add(excelMappingProperty);
            }
        }
        if (propertyList.isEmpty()) {
            throw new ExcelKitAnnotationAnalyzeException(
                    "[" + clazz.getName() + "] @ExcelField annotations not found.");
        }
        excelMapping.setPropertyList(propertyList);
        return excelMapping;
    }

    private static ExcelMapping loadExcelMappingByXml(String clazzName) throws Exception {
        ExcelMapping excelMapping = new ExcelMapping();
        File config = PathUtil
                .getFileByClasspath(String.format("excel-mapping/%s.xml", clazzName));
        String configFile = "classpath:excel-mapping/" + config.getName();
        if (!config.exists()) {
            throw new ExcelKitConfigFileNotFoundException(
                    "[" + configFile + "] not found.");
        }
        SAXReader reader = new SAXReader();
        Document document = reader.read(config);
        Element rootElement = document.getRootElement();
        if (!"excel-mapping".equals(rootElement.getName())) {
            throw new ExcelKitXmlAnalyzeException(
                    "[" + configFile + "] <excel-mapping /> not found.");
        }
        Attribute nameAttr = rootElement.attribute("name");
        if (null == nameAttr) {
            throw new ExcelKitXmlAnalyzeException(
                    "[" + configFile + "] <excel-mapping> attribute \"name\"  not found.");
        }
        excelMapping.setName(nameAttr.getValue());
        List<ExcelProperty> propertyList = Lists.newArrayList();
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element element = elementIterator.next();
            if ("property".equals(element.getName())) {
                List<Attribute> attributes = element.attributes();
                ExcelMappingFactory.checkXmlPropertyRequiredAttr(configFile, attributes);

                ExcelProperty excelMappingProperty = null;
                for (Attribute attribute : attributes) {
                    if (null == excelMappingProperty) {
                        excelMappingProperty = new ExcelProperty();
                    }
                    String name = attribute.getName();
                    String value = attribute.getValue();
                    BeanUtil.setComplexProperty(excelMappingProperty, name,
                            ExcelMappingFactory.validAndGetPropertyValue(configFile, name, value));
                }
                if (null != excelMappingProperty) {
                    propertyList.add(excelMappingProperty);
                }
            }
        }
        if (propertyList.isEmpty()) {
            throw new ExcelKitXmlAnalyzeException(
                    "[" + configFile + "] <property /> not found.");
        }
        excelMapping.setPropertyList(propertyList);
        return excelMapping;
    }

    private static void checkXmlPropertyRequiredAttr(String configFile,
                                                     List<Attribute> attributes) {
        Integer containsCount = 0;
        for (Attribute attr : attributes) {
            if (ExcelMappingFactory.mRequeridAttrs.contains(attr.getName())) {
                containsCount++;
            }
        }
        if (containsCount != ExcelMappingFactory.mRequeridAttrs.size()) {
            throw new ExcelKitXmlAnalyzeException(
                    "[" + configFile + "] <property /> missing required attributes: "
                            + ExcelMappingFactory.mRequeridAttrs
                            .toString());
        }
    }

    private static Object validAndGetPropertyValue(
            String configFile, String name, String value) {
        String messageTemplate = String
                .format("[%s] <property %s=\"%s\"/> Analyze failed: ", configFile, name, value);
        if (ExcelMappingFactory.mClazzFields.contains(name)) {
            try {
                return Class.forName(value).newInstance();
            } catch (Exception e) {
                throw new ExcelKitXmlAnalyzeException(messageTemplate + e.getMessage());
            }
        }
        if ("writeConverterExp".equals(name) || "readConverterExp".equals(name)) {
            for (String item : value.split(",")) {
                if (!item.contains("=")) {
                    throw new ExcelKitXmlAnalyzeException(messageTemplate
                            + "Converter Expression error, Reference:[\"1=男,2=女\" or \"男=1,女=2\"].");
                }
            }
        }
        return value;
    }

}
