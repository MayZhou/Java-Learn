package pattern.factory.factorymethod.second;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Creator creator =new ConcreteCreator();
        Product p = creator.cteateProduct(ConcreteProduct1.class);

    }
}
