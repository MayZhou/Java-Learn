package com.mayzhou.runtimeAnnotations;

import java.lang.ref.Reference;

/**
 * @author MayZhou
 */
public @interface BugReport {
    enum Status {UNCONFIRMED,CONFIRMED,FIXED,NOTABUG};
    boolean showStopper() default false;
    String assignedTo() default "[none]";
    Class<?> testCase() default Void.class;
    Status status() default Status.UNCONFIRMED;
    //Reference ref() default @jdk.nashorn.internal.ir.annotations.Reference;
    String[] reportedBy();
}
