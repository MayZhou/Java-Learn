package principle.srp.third.interfaces;

/**
 * 接通电话和挂断属于协议管理
 * 通话属于数据传输
 * @author MayZhou
 */
public interface IPhone {
    //接通电话
    void dial(String phoneNumber);
    //通话
    void chat(Object o);
    //挂断
    void hangup();
}
