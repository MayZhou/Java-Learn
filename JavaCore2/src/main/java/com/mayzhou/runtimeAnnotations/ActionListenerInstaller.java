package com.mayzhou.runtimeAnnotations;


import java.awt.event.ActionListener;
import java.lang.reflect.*;

/**
 * @author MayZhou
 */
public class ActionListenerInstaller {
    /**
     * 处理所有被{@link ActionListenerFor}注解标识的类
     *
     * @param obj 一个有方法被{@link ActionListenerFor}修饰的对象
     */
    public static void processAnnotations(Object obj) {
        Class<?> cl = obj.getClass();
        /*
        遍历对象的所有方法
         */
        for (Method m : cl.getDeclaredMethods()) {

            /**
             * 获取被{@link ActionListenerFor}所标记的方法
             */
            ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
            System.out.println("a.getClass();" + a.getClass());
            System.out.println(a);
            if (a != null) {
                Field f = null;
                try {
                    /**
                     * 获取{@link ActionListenerFor}注解中source属性的值
                     *
                     */
                    String fieldName = a.source();
                    f = cl.getDeclaredField(fieldName);
                    System.out.println(f);
                    f.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                f.setAccessible(true);
                try {
                    addListener(f.get(obj), obj, m);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对于每个被注解的方法，添加一个监听器
     * @param source 获取注解的字段值
     * @param param 被注解的对象
     * @param m 被注解的方法
     */
    public static void addListener(Object source, final Object param, final Method m) {
        System.out.println(source);
        System.out.println(param);
        System.out.println(m);
        //被注解的方法的代理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return m.invoke(param);
            }
        };

        /***
         *
         */
        Object listener = Proxy.newProxyInstance(null, new Class[]{ActionListener.class}, handler);
        Method adder = null;
        try {
            adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            adder.invoke(source, listener);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
