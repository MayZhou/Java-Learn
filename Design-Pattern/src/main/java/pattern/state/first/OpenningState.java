package pattern.state.first;

/**
 * 敞门状态
 *
 * @author MayZhou
 */
public class OpenningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closeingState);
        //动作委托为CloseState来执行
        super.context.getLiftState().close();

    }

    @Override
    public void run() {
//do nothing
    }

    @Override
    public void stop() {
//du nothing
    }
}
