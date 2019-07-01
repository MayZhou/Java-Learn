package pattern.command.fourth;

import pattern.command.third.ConcteteReceiver1;
import pattern.command.third.Receiver;

/**
 * @author MayZhou
 */
public class ConcreteCommand2 extends Command {
    //构造方法声明默认的接收者
    public ConcreteCommand2() {
        super(new ConcteteReceiver1());
    }

    //设置新的接收者
    public ConcreteCommand2(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }
}
