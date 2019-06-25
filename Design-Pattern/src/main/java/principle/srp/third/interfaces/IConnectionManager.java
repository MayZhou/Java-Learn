package principle.srp.third.interfaces;

/**
 * @author MayZhou
 */
public interface IConnectionManager {
    //接通电话
    void dial(String phoneNumber);
    //挂断
    void hangup();
}
