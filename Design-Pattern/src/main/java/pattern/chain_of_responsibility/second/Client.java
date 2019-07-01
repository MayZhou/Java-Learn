package pattern.chain_of_responsibility.second;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<IWomen> arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rand.nextInt(4), "我要出去逛街"));
        }

        IHandler father = new Father();
        IHandler husband = new Husband();
        IHandler son = new Son();
        father.setNext(husband);
        husband.setNext(son);
        for (IWomen women : arrayList) {
            father.HandlerMessage(women);
        }
    }
}
