package principle.dip.third;

import principle.dip.first.ICar;

/**
 * @author MayZhou
 */
public class Driver implements IDriver {
    private ICar car;
    public void setCar(ICar car) {
        this.car = car;
    }

    public void drive() {
        this.car.run();
    }
}
