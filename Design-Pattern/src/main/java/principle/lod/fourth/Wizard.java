package principle.lod.fourth;

import java.util.Random;

/**
 * 通过这样的重构后，Wizard类就只对外公布了一个public方法，即使要修改 first方法的返回值，影响的也仅仅只是Wizard本身，其他类不受影响，这显示了类的高内聚
 * 特性。
 * @author MayZhou
 */
public class Wizard {
    private Random rand = new Random(System.currentTimeMillis());

    //第一步
    private int first() {
        System.out.println("执行第一个方法...");
        return rand.nextInt(100);
    }

    //第二步
    private int second() {
        System.out.println("执行第二个方法...");
        return rand.nextInt(100);
    }

    //第三个方法
    private int third() {
        System.out.println("执行第三个方法...");
        return rand.nextInt(100);
    }

    //软件安装过程
    public void installWizard() {
        int first = this.first();
        //根据first返回的结果，看是否需要执行second
        if (first > 50) {
            int second = this.second();
            if (second > 50) {
                int third = this.third();
                if (third > 50) {
                    this.first();
                }
            }
        }
    }
}
