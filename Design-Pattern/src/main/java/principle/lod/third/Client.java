package principle.lod.third;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        InstallSoftware invoker = new InstallSoftware();
        invoker.installWizard(new Wizard());
    }
}
