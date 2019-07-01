package pattern.command.second;

/**
 * 负责人
 * @author MayZhou
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    //执行命令
    public void action(){
        this.command.execute();
    }
}
