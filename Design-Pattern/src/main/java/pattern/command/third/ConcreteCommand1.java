package pattern.command.third;

/**
 * @author MayZhou
 */
public class ConcreteCommand1 extends Command {
    //命令类需要知道自己能够命令的接收者
    private Receiver resciver;

    public ConcreteCommand1(Receiver resciver) {
        this.resciver = resciver;
    }

    @Override
    public void execute() {
        this.resciver.doSomething();
    }
}
