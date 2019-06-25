package principle.lsp.fourth;

import principle.lsp.first.abstr.ext.Rifle;
import principle.lsp.fourth.ext.AUG;

/**
 *
 * @author MayZhou
 */
public class Client4 {
    /**
     * 向下转型（downcast）是不安全的
     * @exception java.lang.ClassCastException
     * @param args
     */
    public static void main(String[] args) {
        Sniper sanmao = new Sniper();
        sanmao.setRifle((AUG) new Rifle());
        sanmao.killEnemy();
    }
}
