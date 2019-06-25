package principle.srp.third.face;

import principle.srp.third.interfaces.IConnectionManager;
import principle.srp.third.interfaces.IDataTransfer;
import principle.srp.third.interfaces.impl.ConnectionManagerImpl;
import principle.srp.third.interfaces.impl.DataTransferImpl;

/**
 * 组合模式，耦合过重、类的数量增加
 * 面向接口编程，{@link Phone2}比{@link Phone}更加好
 * @author MayZhou
 */
public class Phone {
    IDataTransfer iDataTransfer = new DataTransferImpl();
    IConnectionManager iConnectionManager = new ConnectionManagerImpl();
}
