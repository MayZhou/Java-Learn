package pattern.factory.factorymethod.multifactory.first;


/**
 * 顶层已经不需要再限制（或者不需要）传递参数,只需要通过方法的返回值限制顶层类型
 * 因为下层factory都有了自己明确的职责
 * @author MayZhou
 */
public abstract class AbstractHumanFactory {
    //必须是Class类型；
    //必须是Human的实现类。
    public abstract Human createHuman();
}
