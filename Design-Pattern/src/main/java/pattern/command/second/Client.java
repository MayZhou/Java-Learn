package pattern.command.second;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        System.out.println("------------客户要求删除一个页面---------------");
        Command command = new DeletePageCommand();
        invoker.setCommand(command);
        invoker.action();
    }
}
