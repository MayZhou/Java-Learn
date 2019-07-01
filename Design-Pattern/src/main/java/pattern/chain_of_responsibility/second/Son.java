package pattern.chain_of_responsibility.second;

/**
 * @author MayZhou
 */
public class Son extends IHandler {
    public Son() {
        super(IHandler.SON_LEVEL_REQUEST);
    }

    public Son(int leval) {
        super(leval);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------母亲向儿子请示-------");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是：同意\n");
    }
}
