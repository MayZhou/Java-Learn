package com.mayzhou.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.lang.System.*;

/**
 * @author MayZhou
 */
public class ScriptTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            try {
                ScriptEngineManager manager = new ScriptEngineManager();
                String language;
                if (args.length == 0) {
                    out.println("Available factories: ");
                    for (ScriptEngineFactory factory : manager.getEngineFactories()) {
                        out.println(factory.getEngineName());
                    }
                    language = "nashorn";
                } else {
                    language = args[0];
                }
                final ScriptEngine engine = manager.getEngineByName(language);
                if (engine == null) {
                    out.println("No engine fo " + language);
                    exit(1);
                }
                final String frameClassName = args.length < 2 ? "com.mayzhou.script.ButtonFrame" : args[1];
                JFrame frame = (JFrame) Class.forName(frameClassName).newInstance();
                InputStream in = frame.getClass().getResourceAsStream("init." + language);
                if (in != null) {
                    engine.eval(new InputStreamReader(in));
                }
                Map<String, Component> componentMap = new HashMap<>();
                getComponentBinding(frame, componentMap);
                componentMap.forEach((name, c) -> engine.put(name, c));
                final Properties events = new Properties();
                in = frame.getClass().getResourceAsStream(language + ".properties");
                events.load(in);
                for (final Object e : events.keySet()) {
                    String[] s = ((String) e).split("\\.");
                    addListener(s[0], s[1], (String) events.get(e), engine, componentMap);
                }
                frame.setTitle("ScriptTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void addListener(String beanName, String eventName, final String scriptCode, final ScriptEngine engine, Map<String, Component> componentMap) {
        Object bean = componentMap.get(beanName);
        EventSetDescriptor descriptor = getEventSetDescriptor(bean, eventName);
        if (descriptor == null) {
            return;
        }
        try {
            descriptor.getAddListenerMethod().invoke(bean, Proxy.newProxyInstance(null, new Class[]{descriptor.getListenerType()}, (proxy, method, args) -> {
                engine.eval(scriptCode);
                return null;
            }));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static EventSetDescriptor getEventSetDescriptor(Object bean, String eventName) {
        try {
            for (EventSetDescriptor descriptor : Introspector.getBeanInfo(bean.getClass()).getEventSetDescriptors()) {
                if (descriptor.getName().equals(eventName)) {
                    return descriptor;
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getComponentBinding(Component c, Map<String, Component> componentMap) {
        String name = c.getName();
        if (name != null) {
            componentMap.put(name, c);
        }
        if (c instanceof Container) {
            for (Component child : ((Container) c).getComponents()) {
                getComponentBinding(child, componentMap);
            }
        }
    }
}
