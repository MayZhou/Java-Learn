package pattern.factory.factorymethod.lazy_initialization.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MayZhou
 */
public class ProductFactory {
    private static final Map<String , Product> prMap = new HashMap<>();
    public static synchronized Product createProduct(String type){
        Product product = null;
        if (prMap.containsKey(type)){
            product = prMap.get(type);
        }else {
            if (type.equals("Product1")){
                product = new ConcreteProduct1();
            }
            if (type.equals("Product2")){
                product = new ConcreteProduct2();
            }
            prMap.put(type,product);
        }
        return product;
    }
}
