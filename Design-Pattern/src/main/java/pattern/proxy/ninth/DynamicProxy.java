package pattern.proxy.ninth;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author MayZhou
 */
public class DynamicProxy {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
        if (true){
            (new BeforeAdvice()).exec();
        }
        T newProxyInstance = (T) Proxy.newProxyInstance(loader,interfaces, h);
        return newProxyInstance;
    }
}
