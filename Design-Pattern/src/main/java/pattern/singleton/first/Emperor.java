package pattern.singleton.first;

/**
 * 皇帝类（只能有一个皇帝）
 *
 * @author MayZhou
 */
public class Emperor {
    private static final Emperor EMPEROR = new Emperor();

    //构造方法私有，避免被其他类new出一个对象
    private Emperor() {
    }
    public static Emperor getInstance(){
        return EMPEROR;
    }
    public static void say(){
        System.out.println("我就是皇帝某某某。。。。");
    }
}
