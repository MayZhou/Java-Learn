package pattern.factory.factorymethod.second;

/**
 * @author MayZhou
 */
public class ConcreteCreator extends Creator {
    @Override
    public <T extends Product> T cteateProduct(Class<T> c) {
        Product product =null;
        try {
            product = (T) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
