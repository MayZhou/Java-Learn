package pattern.command.fourth;

import pattern.command.third.Receiver;

/**
 * 完美的命令类
 * @author MayZhou
 */
public abstract class Command {
    //定义一个子类的全局共享变量,接收者可以有很多个
    protected  final Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    //每个命令类都必须有一个执行命令的方法
    public abstract void execute();
}
