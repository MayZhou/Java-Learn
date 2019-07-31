package com.mayzhou.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author MayZhou
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[100];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            /**
             * @param   loader the class loader to define the proxy class
             * @param   interfaces the list of interfaces for the proxy class
             *          to implement
             * @param   h the invocation handler to dispatch method invocations to
             */
            Object proxy = Proxy.newProxyInstance(null,value.getClass().getInterfaces(),handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1 ;
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) System.out.println(elements[result]);
    }
}

class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target);
        System.out.println("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target,args);
    }
}
