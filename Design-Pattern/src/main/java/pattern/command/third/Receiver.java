package pattern.command.third;

/**
 * 接收者（最后干活的）,为什么是抽象类，因为接收者可以是复数
 * @author MayZhou
 */
public abstract class Receiver {
    public abstract void doSomething();
}
