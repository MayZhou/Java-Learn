package pattern.builder.first;

import java.util.ArrayList;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<String> sequence  = new ArrayList<>();  //存放run的顺序
        sequence.add("engine boom");  //客户要求，run的时候时候先发动引擎
        sequence.add("start");  //启动起来
        sequence.add("stop");  //开了一段就挺下来
        //要一个宝马车：
        BenzBuilder benzBuilder = new BenzBuilder();
        //把顺序给这个builder类，制造出这样一个车出来
        benzBuilder.setSequence(sequence);
        //制造出一个宝马车
        BenzModel benz = (BenzModel)benzBuilder.getCarModel();
        //宝马车跑一下看看
        benz.run();
    }
}
