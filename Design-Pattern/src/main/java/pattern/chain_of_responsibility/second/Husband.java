package pattern.chain_of_responsibility.second;

/**
 * @author MayZhou
 */
public class Husband extends IHandler {


    public Husband() {
        super(IHandler.HUSBAND_LEVEL_REQUEST);
    }

    public Husband(int leval) {
        super(leval);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }
}
