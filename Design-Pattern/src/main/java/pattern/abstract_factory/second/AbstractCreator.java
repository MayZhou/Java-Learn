package pattern.abstract_factory.second;

/**
 * 有N个产品族，在抽象工厂类中就应该有N个创建方法。
 * @author MayZhou
 */
public abstract class AbstractCreator {
    //创建A产品家族
    public abstract AbstractProductA createProductA();
    //创建B产品家族
    public abstract AbstractProductB createProductB();
}
