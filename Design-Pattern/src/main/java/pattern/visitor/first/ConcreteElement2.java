package pattern.visitor.first;

/**
 * @author MayZhou
 */
public class ConcreteElement2 extends Element {
    @Override
    public void doSomething() {

    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
