package pattern.command.third;

/**
 * 调用者（调用命令类）
 * @author MayZhou
 */
public class Invoker {
    private Command command;

    //setter方法注入
    public void setCommand(Command command) {
        this.command = command;
    }
    //执行命令
    public void action(){
        this.command.execute();
    }
}
