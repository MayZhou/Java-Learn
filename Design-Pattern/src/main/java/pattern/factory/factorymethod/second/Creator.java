package pattern.factory.factorymethod.second;

/**
 * 抽象创建类，也就是抽象工厂，具体如何创建产品是由具体的实现工厂{@link ConcreteCreator}完成的
 * @author MayZhou
 */
public abstract class Creator {
    public abstract <T extends Product> T cteateProduct(Class<T> c);
}
