package pattern.proxy.fifth;

/**
 * 还是不行
 * @author MayZhou
 */
public class Client2 {
    public static void main(String[] args) {
        //定义个游戏的角色
        IGamePlayer player = new GamePlayer("张三");
        //这个代理是自己new出来的，player不认
        IGamePlayer proxy = new GamePlayerProxy(player);
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
