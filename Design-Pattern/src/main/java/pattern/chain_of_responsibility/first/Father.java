package pattern.chain_of_responsibility.first;

/**
 * @author MayZhou
 */
public class Father implements IHandler {
    //未出嫁的女性
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("女儿的请示是：" + women.getRequest());
        System.out.println("父亲的答复是:同意");
    }
}
