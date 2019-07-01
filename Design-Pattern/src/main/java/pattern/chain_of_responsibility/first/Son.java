package pattern.chain_of_responsibility.first;

/**
 * @author MayZhou
 */
public class Son implements IHandler {
    //已出嫁的女性，丈夫已死，有儿子
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("母亲的请示是：" + women.getRequest());
        System.out.println("儿子的答复是：同意");
    }
}
