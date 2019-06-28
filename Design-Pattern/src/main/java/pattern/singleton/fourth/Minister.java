package pattern.singleton.fourth;

/**
 * @author MayZhou
 */
public class Minister {
    public static void main(String[] args) {
        int ministerNum = 5;
        for (int i=0 ;i<ministerNum;i++){
            Emperor emperor = Emperor.getInstance();
            System.out.print(i+"号大臣参拜的是：");
            emperor.say();
        }
    }
}
