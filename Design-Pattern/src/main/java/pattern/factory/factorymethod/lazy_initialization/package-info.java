/**
 * 何为延迟初始化（Lazy initialization）？一个对象被消费完毕后，并不立刻释放，工厂类
 * 保持其初始状态，等待再次被使用。
 * 延迟加载框架是可以扩展的，例如限制某一个产品类的最大实例化数量，可以通过判断 Map中已有的对象数量来实现，这样的处理是非常有意义的，例如JDBC连接数据库，都会 要求设置一个MaxConnections最大连接数量，该数量就是内存中最大实例化的数量。
 * 延迟加载还可以用在对象初始化比较复杂的情况下，例如硬件访问，涉及多方面的交
 * 互，则可以通过延迟加载降低对象的产生和销毁带来的复杂性。
 * @author MayZhou
 */
package pattern.factory.factorymethod.lazy_initialization;