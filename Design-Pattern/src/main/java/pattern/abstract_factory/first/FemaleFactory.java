package pattern.abstract_factory.first;

/**
 * @author MayZhou
 */
public class FemaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }
}
