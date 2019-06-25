package principle.dip.first;

/**
 * @author MayZhou
 */
public class Driver implements IDriver {
    public void drive(ICar car) {
        car.run();
    }
}
