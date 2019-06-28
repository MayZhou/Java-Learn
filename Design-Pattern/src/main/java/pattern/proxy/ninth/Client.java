package pattern.proxy.ninth;

import java.lang.reflect.InvocationHandler;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler invocationHandler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),invocationHandler);
        proxy.doSomething("Finish");
    }
}
