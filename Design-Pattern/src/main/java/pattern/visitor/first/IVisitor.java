package pattern.visitor.first;

/**
 * @author MayZhou
 */
public interface IVisitor {

    //可以访问哪些对象
    public void visit(Element element);

}
