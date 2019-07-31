package com.mayzhou.runtimeAnnotations.excelkit.exception;

/**
 * @author MayZhou
 */
public class ExcelKitEncounterNoNeedXmlException extends ExcelKitRuntimeException {


    private static final long serialVersionUID = 121522372336576772L;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExcelKitEncounterNoNeedXmlException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ExcelKitEncounterNoNeedXmlException() {
    }
}
