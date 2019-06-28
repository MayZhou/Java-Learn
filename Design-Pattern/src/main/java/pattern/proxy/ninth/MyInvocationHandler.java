package pattern.proxy.ninth;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author MayZhou
 */
public class MyInvocationHandler implements InvocationHandler {

    //被代理的实例
    private Object obj = null;

    //我要代理谁
    public MyInvocationHandler(Object _obj){
        this.obj = _obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);
        //如果是登录方法，则发送信息
        return result;
    }
}
