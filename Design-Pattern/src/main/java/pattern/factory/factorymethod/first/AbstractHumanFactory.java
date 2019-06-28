package pattern.factory.factorymethod.first;

/**
 * @author MayZhou
 */
public abstract class AbstractHumanFactory {
    //必须是Class类型；
    //必须是Human的实现类。
    public abstract <T extends Human> T createHuman(Class<T> c);
}
