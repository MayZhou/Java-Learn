package pattern.factory.factorymethod.multifactory.first;

/**
 * @author MayZhou
 */
public class YellowHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new  YellowHuman();
    }
}
