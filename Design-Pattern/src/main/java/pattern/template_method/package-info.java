/**
 * 模板方法模式（Template Method Pattern）是如此简单，以致让你感觉你已经能够掌握其
 * 精髓了。其定义如下：
 * Define the skeleton of an algorithm in an operation,deferring some steps to subclasses.Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.（定义一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改
 * 变一个算法的结构即可重定义该算法的某些特定步骤。）
 * {@link pattern.template_method.second.HummerModel}的run()方法就是模板，其他方法延迟到子类
 * 其中，AbstractClass叫做抽象模板，它的方法分为两类：
 * <ol>
 *     <li>基本方法也叫做基本操作，是由子类实现的方法，并且在模板方法被调用。</li>
 *     <li>可以有一个或几个，一般是一个具体方法，也就是一个框架，实现对基本方法的调度，
 * 完成固定的逻辑。</li>
 * <li>抽象模板中的基本方法尽量设计为protected类型，符合迪米特法则，不需要暴露 的属性或方法尽量不要设置为protected类型。实现类若非必要，尽量不要扩大父类中的访问
 * 权限。</li>
 * </ol>
 * 优点
 * <ol>
 *     <li> 封装不变部分，扩展可变部分</li>
 *     <li>提取公共部分代码，便于维护</li>
 *     <li> 行为由父类控制，子类实现</li>
 * </ol>
 * 使用场景:
 * <ol>
 *     <li>多个子类有公有的方法，并且逻辑基本相同时。</li><Li>重要、复杂的算法，可以把核心算法设计为模板方法，周边的相关细节功能则由各个
 * 子类实现。</Li><li>重构时，模板方法模式是一个经常使用的模式，把相同的代码抽取到父类中，然后通 过钩子函数（见“模板方法模式的扩展”）约束其行为。</li>
 * </ol>
 * @author MayZhou
 */
package pattern.template_method;