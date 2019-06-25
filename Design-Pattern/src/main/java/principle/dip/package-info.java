/**
 * 依赖倒置原则（Dependence Inversion Principle,DIP）
 * <br/>
 * High level modules should not depend upon low level modules.Both should depend upon abstractions.Abstractions should not depend upon details.Details should depend upon abstractions.
 * <ol>
 * <li>高层模块不应该依赖低层模块，两者都应该依赖其抽象；</li>
 * <li>抽象不应该依赖细节；</li>
 * <li> 细节应该依赖抽象。</li>
 * <li>高层模块和低层模块容易理解，每一个逻辑的实现都是由原子逻辑组成的，不可分割的原子逻辑就是低层模块，原子逻辑的再组装就是高层模块。</li>
 * <li>在Java语言中，抽象就是指接口或抽象类，两者都是不能直接被实例化的；</li>
 * <li>细节就是实现类，实现接口或继承抽象类而产生的类就是细节，其特点就是可以直接被实例化，也就是 可以加上一个关键字new产生一个对象。</li>
 * </ol>
 *。依赖倒置原则在Java语言中的表现就是：
 * <ol>
 *     <li>模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的；</li>
 *     <li>接口或抽象类不依赖于实现类；</li>
 *     <li>实现类依赖接口或抽象类。</li>
 *     <li>总之：面向接口编程</li>
 * </ol><br/>
 * 作用
 * <ol>
 *     <li>以减少类间的耦合性，提高系统的稳定性，降低并行开发引起的风险，提高代码的可读性和可维护性。</li>
 *     <li>依赖倒置对并行开发的影响。两个类之间有依赖关系，只要制定出两者之间的接口（或抽象类）就可以独立开发了，而且项目之间的单元测试也可以独立地运行，</li>
 *     <li>TDD（Test-Driven Development，测试驱动开发）开发模式就是依赖倒置原则的最高级应 用。</li>
 * </ol>
 *
 * 对象的依赖关系有三种方式来传递
 * <ol>
 *     <li>构造函数传递依赖对象{@link principle.dip.second.Driver}</li>
 *     <li>Setter方法传递依赖对象{@link principle.dip.third.Driver}</li>
 *     <li>接口声明依赖对象{@link principle.dip.first.IDriver}</li>
 * </ol>
 *
 * 最佳实现<br/>
 * 依赖倒置原则的本质就是通过抽象（接口或抽象类）使各个类或模块的实现彼此独立，
 * 不互相影响，实现模块间的松耦合，我们怎么在项目中使用这个规则呢？只要遵循以下的几
 * 个规则就可以：<br/>
 * <ol>
 *     <li>每个类尽量都有接口或抽象类，或者抽象类和接口两者都具备</li>
 *     <li>变量的表面类型尽量是接口或者是抽象类</li>
 *     <li>任何类都不应该从具体类派生</li>
 *     <li>尽量不要覆写基类的方法</li>
 * </ol>
 *
 * @author MayZhou
 */
package principle.dip;