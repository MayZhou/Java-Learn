package pattern.factory.factorymethod.multifactory.first;

/**
 * @author MayZhou
 */
public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new BlackHuman();
    }
}
