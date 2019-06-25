package principle.dip.second;

import principle.dip.first.ICar;

/**
 * 构造函数传递依赖对象
 *
 * @author MayZhou
 */
public class Driver implements IDriver {
    private ICar car;

    public Driver(ICar car) {
        this.car = car;
    }

    public void drive() {
        this.car.run();
    }
}
