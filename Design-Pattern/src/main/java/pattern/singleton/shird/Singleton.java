package pattern.singleton.shird;

/**
 * @author MayZhou
 */
public class Singleton {
    //构建final static私有对象
    private static  Singleton SINGLETON = null;

    //私有构造方法，限制产生多个对象
    private Singleton() {
    }

    //暴露public方法获得唯一实例对象
    public static Singleton getInstance() {
        if(SINGLETON ==null){
            SINGLETON = new Singleton();
        }
        return SINGLETON;
    }

}
