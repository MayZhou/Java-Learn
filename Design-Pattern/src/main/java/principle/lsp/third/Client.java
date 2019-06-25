package principle.lsp.third;

import principle.lsp.first.user.Soldier;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Soldier sanmao = new Soldier();
        //可以在AbstractToy中声明将声音、形状都委托给AbstractGun处理，仿真枪嘛，形
        //状和声音都要和真实的枪一样了，然后两个基类下的子类自由延展，互不影响。下面注释的代码就不会出现业务逻辑混乱的情况
        //sanmao.setGun(new ToyGun());
    }
}
