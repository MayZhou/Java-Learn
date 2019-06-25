package principle.dip.third;

import principle.dip.first.ICar;

/**
 * @author MayZhou
 */
public interface IDriver {
    public void setCar(ICar car);
    public void drive();
}
