package principle.lsp.fourth;

import principle.lsp.fourth.ext.AUG;

/**
 * @author MayZhou
 */
public class Sniper {
    //定义一个狙击枪
    private AUG aug;

    //给狙击手一般狙击枪
    public void setRifle(AUG _aug){
        this.aug = _aug;
    }

    public void killEnemy(){
        //首先看看敌人的情况，别杀死敌人，自己也被人干掉
        aug.zoomOut();
        //开始射击
        aug.shoot();
    }
}
