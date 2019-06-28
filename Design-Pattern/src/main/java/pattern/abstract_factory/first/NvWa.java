package pattern.abstract_factory.first;

/**
 * @author MayZhou
 */
public class NvWa {
    public static void main(String[] args) {
        HumanFactory maleHumanFactory = new MaleFactory();
        HumanFactory femaleFactory = new FemaleFactory();
        Human maleHumanFactoryYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleFactoryYellowHuman = femaleFactory.createYellowHuman();
        maleHumanFactoryYellowHuman.getColor();

        maleHumanFactoryYellowHuman.getSex();
        maleHumanFactoryYellowHuman.talk();
        femaleFactoryYellowHuman.getSex();
        femaleFactoryYellowHuman.getColor();
        femaleFactoryYellowHuman.talk();
    }
}
