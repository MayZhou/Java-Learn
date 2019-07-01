package pattern.chain_of_responsibility.second;

/**
 * @author MayZhou
 */
public class Father extends IHandler {

    ////父亲只处理女儿的请求
    public Father() {
        super(IHandler.FATHER_LEVEL_REQUEST);
    }

    public Father(int leval) {
        super(leval);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是:同意\n");
    }
}
