package pattern.proxy.fourth;

import pattern.proxy.first.IGamePlayer;

/**
 * 仅仅修改了构造函数，传递进来一个代理者名称，即可进行代理，在这种改造下，系统
 * 更加简洁了，调用者只知道代理存在就可以，不用知道代理了谁。
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        //然后再定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy("张三");

        //开始打游戏，记下时间戳
        System.out.println("开始时间是：2009-8-25 10:45");
        proxy.login("zhangSan", "password");
        //开始杀怪
        proxy.killBoss();
        //升级
        proxy.upgrade();
        //记录结束游戏时间
        System.out.println("结束时间是：2009-8-26 03:40");
    }

}
