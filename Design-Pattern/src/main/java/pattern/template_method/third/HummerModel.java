package pattern.template_method.third;

/**
 * ，两个实现类的run()方法都是完全相同的，那 这个run()方法的实现应该出现在抽象类
 *
 * @author MayZhou
 */
public abstract class HummerModel {
    /**
     * 首先，这个模型要能够被发动起来，别管是手摇发动，还是电力发动，反正      * 是要能够发动起来，那这个实现要在实现类里了
     */
    protected abstract void start();

    //能发动，还要能停下来，那才是真本事
    protected abstract void stop();

    //喇叭会出声音，是滴滴叫，还是哔哔叫
    protected abstract void alarm();

    //引擎会轰隆隆地响，不响那是假的
    protected abstract void engineBoom();

    /**
     * 钩子函数
     * 需要子类的输入参数范围比父类的小
     * 如果子类的参数范围比父类小，调用子类的方法，
     * 覆写或实现父类的方法时输出结果可以被缩小
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }

    //那模型应该会跑吧，别管是人推的，还是电力驱动的，总之要会跑
    public void run() {
        //先发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();
        //然后就开始跑了，跑的过程中遇到一条狗挡路，就按喇叭

        if (this.isAlarm()) {
            this.alarm();
        }
        //到达目的地就停车
        this.stop();
    }

    ;
}
