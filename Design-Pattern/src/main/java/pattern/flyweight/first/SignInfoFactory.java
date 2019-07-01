package pattern.flyweight.first;

/**
 * @author MayZhou
 */
public class SignInfoFactory {

    public static SignInfo getSignInfo() {
        return new SignInfo();
    }
}
