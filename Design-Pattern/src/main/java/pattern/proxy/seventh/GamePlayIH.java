package pattern.proxy.seventh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author MayZhou
 */
public class GamePlayIH implements InvocationHandler {

    //被代理的实例
    Object obj = null;

    //我要代理谁
    public GamePlayIH(Object obj) {
        this.obj = obj;
    }

    //其中invoke方法是接口InvocationHandler定义必须实现的，它完成对真实方法的调用。
    //，动态代理是根据被代理的接口生成所有的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj,args);
        return result;
    }
}
