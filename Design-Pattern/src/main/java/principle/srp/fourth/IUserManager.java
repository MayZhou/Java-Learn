package principle.srp.fourth;

import principle.srp.second.interfaces.IUserBO;

/**
 *
 * 颗粒度很粗
 * ，根据传递的类型不同，把可变长度参数 changeOptions修改到userBO这个对象上，并调用持久层的方法保存到数据库中。
 * 方法职责不清晰，让别人猜测这个方法可能是用来处理什么逻辑
 * @author MayZhou
 */
public interface IUserManager {
    void changeUser(IUserBO userBO, String... changeOptions);
}
