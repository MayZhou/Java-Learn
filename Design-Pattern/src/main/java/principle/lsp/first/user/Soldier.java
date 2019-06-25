package principle.lsp.first.user;

import principle.lsp.first.abstr.AbstractGun;

/**
 * @author MayZhou
 */
public class Soldier {
    private AbstractGun abstractGun;
    public void setGun(AbstractGun _gun){
        this.abstractGun = _gun;
    }
    public void killEnemy(){
        System.out.println("士兵开始杀敌人...");
        abstractGun.shoot();
    }
}
