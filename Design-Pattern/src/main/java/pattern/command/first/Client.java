package pattern.command.first;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("-----------客户要求增加一项需求---------------");
        Group rg = new RequirmentGroup();
        rg.find();
        rg.add();
        rg.plan();
    }
}
