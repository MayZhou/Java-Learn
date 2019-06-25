package principle.lsp.second;

import principle.lsp.first.user.Soldier;
import principle.lsp.second.abstr.ext.ToyGun;

/**
 * 玩具枪不能射击，不能直接继承
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Soldier sanmao = new Soldier();
        sanmao.setGun(new ToyGun());
        //玩具枪不能杀敌
        sanmao.killEnemy();
    }
}
