package pattern.builder.first;

import java.util.ArrayList;

/**
 * @author MayZhou
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benz = new BenzModel();
    @Override
    public void setSequence(ArrayList sq) {
        this.benz.setSequence(sq);
    }

    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
