package pattern.mediator.second;

/**
 * @author MayZhou
 * 抽象同事类
 */
public abstract class AbstractColleague {
    //指定中介者
    //继承该类的所有子类都将实现重写该方法
    //与此同时，中介者需要注入所有被中介的类用于中介者和被中介的交互
    protected AbstractMediator mediator;
    public AbstractColleague(AbstractMediator _mediator){
        this.mediator = _mediator;
    }
}
