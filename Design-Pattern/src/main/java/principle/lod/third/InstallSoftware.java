package principle.lod.third;

/**
 * Wizard类把太多的方法暴露给InstallSoftware类，两者的朋友关系太亲密了，耦合关系变得异 常牢固。
 * @author MayZhou
 */
public class InstallSoftware {
    public void installWizard(Wizard wizard) {
        int first = wizard.first();
        //根据first返回的结果，看是否需要执行second
        if (first > 50) {
            int second = wizard.second();
            if (second > 50) {
                int third = wizard.third();
                if (third > 50) {
                    wizard.first();
                }
            }
        }
    }
}
