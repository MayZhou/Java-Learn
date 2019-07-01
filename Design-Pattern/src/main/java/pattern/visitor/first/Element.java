package pattern.visitor.first;

/**
 * 抽象元素
 * @author MayZhou
 */
public abstract class Element {

    public abstract void doSomething();

    public abstract void accept(IVisitor visitor);
}
