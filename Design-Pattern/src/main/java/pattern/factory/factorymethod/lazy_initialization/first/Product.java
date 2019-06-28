package pattern.factory.factorymethod.lazy_initialization.first;

/**
 * 抽象产品类负责定义产品的共性，实现对事物最抽象的定义
 * @author MayZhou
 */
public abstract class Product {
    //产品的公有方法
    public void method1(){}
    //抽象方法
    public abstract void method2();
}
