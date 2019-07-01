package pattern.chain_of_responsibility.second;

/**
 * @author MayZhou
 */
public abstract class IHandler {

    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    private int leval =0;

    private IHandler nextHandler;

    //能处理的级别
    public IHandler(int leval) {
        this.leval = leval;
    }

    public final void HandlerMessage(IWomen women){
        if (women.getType() == this.leval){
            this.response(women);
        }else {
            if (this.nextHandler != null) {
                this.nextHandler.HandlerMessage(women);
            }else {
                System.out.println("---没地方请示了，按不同意处理---\n");
            }
        }
    }

    public void setNext(IHandler handler){
        this.nextHandler = handler;
    }
    protected abstract void response(IWomen women);
}
