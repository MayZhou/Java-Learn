package pattern.command.third;

/**
 * 根据环境的需求，一般不止一个命令
 * @author MayZhou
 */
public abstract class Command {
    //具体要执行的命令
    public abstract void execute();
}
