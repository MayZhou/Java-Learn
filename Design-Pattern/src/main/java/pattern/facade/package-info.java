/**门面模式（Facade Pattern）也叫做外观模式，是一种比较常用的封装模式，其定义如
 下：
 Provide a unified interface to a set of interfaces in a subsystem.Facade defines a higher-level interface that makes the subsystem easier to use.（要求一个子系统的外部与其内部的通信必须通
 过一个统一的对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。）

 门面对象参与了业务逻辑，门
 面对象只是提供一个访问子系统的一个路径而已，它不应该也不能参与具体的业务逻辑，否
 则就会产生一个倒依赖的问题：子系统必须依赖门面才能被访问，这是设计上一个严重错
 误，不仅违反了单一职责原则，同时也破坏了系统的封装性。

 * @author MayZhou
 */
package pattern.facade;