package pattern.proxy.sixth;

/**
 * @author MayZhou
 */
public interface IGamePlayer {
    //登录游戏
    public void login(String user, String password);

    //杀怪，这是网络游戏的主要特色
    public void killBoss();

    //升级
    public void upgrade();
}
