package principle.lsp.fifth;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author MayZhou
 */
public class Father {
    public Collection doSomething(HashMap map) {
        System.out.println("父类被执行...");
        return map.values();
    }
}
