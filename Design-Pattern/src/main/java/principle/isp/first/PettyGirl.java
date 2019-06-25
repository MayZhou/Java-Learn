package principle.isp.first;

/**
 * @author MayZhou
 */
public class PettyGirl implements IPettyGirl {
    private String name;

    public PettyGirl(String name) {
        this.name = name;
    }

    public PettyGirl() {
    }

    public void goodLooking() {
        System.out.println(this.name + "---脸蛋很漂亮!");
    }

    public void niceFigure() {
        System.out.println(this.name + "---气质非常好!");
    }

    public void greatTemperament() {
        System.out.println(this.name + "---身材非常棒!");
    }
}
