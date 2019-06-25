package principle.lsp.fifth;

import java.util.HashMap;

/**
 * @author MayZhou
 */
public class Client {
    public static void invoker() {
        //父类存在的地方，子类就应该能够存在
        Father f = new Father();
        HashMap map = new HashMap();
        f.doSomething(map);
    }

    public static void invoker1() {
        //父类存在的地方，子类就应该能够存在
        Son f = new Son();
        HashMap map = new HashMap();
        f.doSomething(map);
    }

    public static void main(String[] args) {
        invoker();
        invoker1();
    }
}
