package pattern.singleton.fourth;

import java.util.ArrayList;
import java.util.Random;

/**
 * 固定数量的皇帝类
 *
 * @author MayZhou
 */
public class Emperor {
    //定义最多能产生的实例数量
    private static int maxNumOfEmperor = 2;
    //每个皇帝都有名字，使用一个ArrayList来容纳，每个对象的私有属性
    private static ArrayList<String> nameList = new ArrayList<>();
    //定义一个列表，容纳所有的皇帝实例
    private static ArrayList<Emperor> emperorArrayList = new ArrayList<>();
    //当前皇帝序列号
    private static int countNumOfEmperor = 0;

    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorArrayList.add(new Emperor("皇帝" + i));
        }
    }

    private Emperor(String name) {
        nameList.add(name);
    }

    private Emperor() {
        //世俗和道德约束你，目的就是不产生第二个皇帝
    }


    public static Emperor getInstance(){
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperorArrayList.get(countNumOfEmperor);
    }
    public static void say(){
        System.out.println(nameList.get(countNumOfEmperor));
    }
}
