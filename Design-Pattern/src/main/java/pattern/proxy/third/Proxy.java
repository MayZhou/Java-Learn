package pattern.proxy.third;

/**
 * @author MayZhou
 */
public class Proxy implements Subject {

    //被代理的对象
    private Subject subject =null;

    //默认被代理者，
    public Proxy() {
        //new Proxy()代理自己
        this.subject = new Proxy();
    }

    //通过构造函数传递被代理者
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    private void before(){}
    private void after(){}

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }
}
