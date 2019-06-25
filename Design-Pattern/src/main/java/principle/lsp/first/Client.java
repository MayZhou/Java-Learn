package principle.lsp.first;

import principle.lsp.first.abstr.ext.MachineGun;
import principle.lsp.first.user.Soldier;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Soldier sanmao = new Soldier();
        sanmao.setGun(new MachineGun());
        sanmao.killEnemy();
    }
}
