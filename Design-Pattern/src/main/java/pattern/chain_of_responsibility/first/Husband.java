package pattern.chain_of_responsibility.first;

/**
 * @author MayZhou
 */
public class Husband implements IHandler {
    //已出嫁的女性，且丈夫未死
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("妻子的请示是：" + women.getRequest());
        System.out.println("丈夫的答复是：同意");
    }
}
