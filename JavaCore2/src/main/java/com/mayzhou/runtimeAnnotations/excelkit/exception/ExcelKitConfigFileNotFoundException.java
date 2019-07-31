package com.mayzhou.runtimeAnnotations.excelkit.exception;

/**
 * @author MayZhou
 */
public class ExcelKitConfigFileNotFoundException extends ExcelKitRuntimeException {


    private static final long serialVersionUID = 2324082985861780915L;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExcelKitConfigFileNotFoundException(String message) {
        super(message);
    }
}
