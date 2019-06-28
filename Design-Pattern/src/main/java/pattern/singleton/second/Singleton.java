package pattern.singleton.second;

/**
 * @author MayZhou
 */
public class Singleton {
    //构建final static私有对象
    private static final Singleton SINGLETON = new Singleton();

    //私有构造方法，限制产生多个对象
    private Singleton() {
    }

    //暴露public方法获得唯一实例对象
    public static Singleton getInstance() {
        return SINGLETON;
    }

   //类中其他方法，尽量是static
    public static void doSomething(){}
}
