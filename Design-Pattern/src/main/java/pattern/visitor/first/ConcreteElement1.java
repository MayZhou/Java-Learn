package pattern.visitor.first;

/**
 * @author MayZhou
 */
public class ConcreteElement1 extends Element {
    @Override
    public void doSomething() {

    }

    //允许那个访问者访问
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
