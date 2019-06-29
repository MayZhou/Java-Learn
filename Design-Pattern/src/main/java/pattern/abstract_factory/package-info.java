/**
 * 抽象工厂模式（Abstract Factory Pattern）是一种比较常用的模式，其定义如下：
 * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.（为创建一组相关或相互依赖的对象提供一个接口，而且无须指定它们
 * 的具体类。）
 *
 *  封装性，每个产品的实现类不是高层模块要关心的，它要关心的是什么？是接口，是
 * 抽象，它不关心对象是如何创建出来，这由谁负责呢？工厂类，只要知道工厂类是谁，我就
 * 能创建出一个需要的对象，省时省力，优秀设计就应该如此。
 * 产品族内的约束为非公开状态。例如生产男女比例的问题上，猜想女娲娘娘肯定有自
 * 己的打算，不能让女盛男衰，否则女性的优点不就体现不出来了吗？那在抽象工厂模式，就 应该有这样的一个约束：每生产1个女性，就同时生产出1.2个男性，这样的生产过程对调用
 * 工厂类的高层模块来说是透明的，它不需要知道这个约束，我就是要一个黄色女性产品就可
 * 以了，具体的产品族内的约束是在工厂内实现的。
 *缺点：<br/>
 * 抽象工厂模式的最大缺点就是产品族扩展非常困难
 * 这严重违反了开闭原则，
 * @author MayZhou
 */
package pattern.abstract_factory;