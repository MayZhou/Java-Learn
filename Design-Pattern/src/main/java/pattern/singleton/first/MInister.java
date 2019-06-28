package pattern.singleton.first;

/**
 * 臣子
 * @author MayZhou
 */
public class MInister {
    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
