/**
 * 建造者模式（Builder Pattern）也叫做生成器模式，其定义如下：
 * Separate the construction of a complex object from its representation so that the same construction process can create different representations.（将一个复杂对象的构建与它的表示分
 * 离，使得同样的构建过程可以创建不同的表示。）
 * 在建造者模式中，有如下4个角色：
 * ● Product产品类
 * 通常是实现了模板方法模式，也就是有模板方法和基本方法，这个参考第10章的模板方 法模式。例子中的BenzModel和BMWModel就属于产品类。
 * ● Builder抽象建造者
 * 规范产品的组建，一般是由子类实现。例子中的CarBuilder就属于抽象建造者。
 * ● ConcreteBuilder具体建造者
 * 实现抽象类定义的所有方法，并且返回一个组建好的对象。例子中的BenzBuilder和 BMWBuilder就属于具体建造者。
 * ● Director导演类
 * 负责安排已有模块的顺序，然后告诉Builder开始建造，在上面的例子中就是我们的老 大，××公司找到老大，说我要这个或那个类型的车辆模型，然后老大就把命令传递给我，我
 * 和我的团队就开始拼命地建造，于是一个项目建设完毕了。
 * 建造者模式的优点
 * ● 封装性
 * 使用建造者模式可以使客户端不必知道产品内部组成的细节，如例子中我们就不需要关 心每一个具体的模型内部是如何实现的，产生的对象类型就是CarModel。
 * ● 建造者独立，容易扩展
 * BenzBuilder和BMWBuilder是相互独立的，对系统的扩展非常有利。
 * ● 便于控制细节风险
 * 由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他的模块产生任
 * 何影响。
 * @author MayZhou
 */
package pattern.builder;