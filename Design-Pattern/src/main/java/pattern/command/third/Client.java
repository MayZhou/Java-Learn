package pattern.command.third;

/**
 * 场景类
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        //声明调用者
        Invoker invoker = new Invoker();
        //声明接收者
        Receiver receiver =new ConcteteReceiver1();

        //发出命令
        Command command = new ConcreteCommand1(receiver);

        //调用者获取命令
        invoker.setCommand(command);
        //调用者执行命令
        invoker.action();
    }

}
