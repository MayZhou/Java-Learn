package pattern.abstract_factory.second;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();
        AbstractProductA productA1 = creator1.createProductA();
        AbstractProductB productB1 = creator1.createProductB();
        AbstractProductB productB2 = creator2.createProductB();
        AbstractProductA productA2 = creator2.createProductA();
    }
}
