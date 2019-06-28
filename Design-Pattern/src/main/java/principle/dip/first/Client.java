package principle.dip.first;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        IDriver zhangSan = new Driver();
        ICar benz = new Benz();
        ICar bmw = new BMW();
        //张三开宝马车
         zhangSan.drive(benz);
        zhangSan.drive(bmw);
    }
}
