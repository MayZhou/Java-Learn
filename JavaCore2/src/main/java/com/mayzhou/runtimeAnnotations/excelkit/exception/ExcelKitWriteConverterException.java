package com.mayzhou.runtimeAnnotations.excelkit.exception;

/**
 * @author MayZhou
 */
public class ExcelKitWriteConverterException extends ExcelKitRuntimeException {
    private static final long serialVersionUID = 2702170553728726722L;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExcelKitWriteConverterException(String message) {
        super(message);
    }
}
