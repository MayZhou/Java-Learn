package pattern.abstract_factory.first;

/**
 * @author MayZhou
 */
public class MaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }
}
