package pattern.factory.factorymethod.multifactory.first;

/**
 * @author MayZhou
 */
public class whiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
