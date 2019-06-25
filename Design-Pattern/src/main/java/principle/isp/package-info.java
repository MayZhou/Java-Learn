/**
 * 接口分为两种：<br/>
 * <ol>
 *     <li> 实例接口（Object Interface），在Java中声明一个类，然后用new关键字产生一个实 例，它是对一个类型的事物的描述，这是一种接口。比如你定义Person这个类，然后使用 Person zhangSan=new Person()产生了一个实例，这个实例要遵从的标准就是Person这个 类，Person类就是zhangSan的接口。疑惑？看不懂？不要紧，那是因为让Java语言浸染的时间 太长了，只要知道从这个角度来看，Java中的类也是一种接口</li>
 *     <li>类接口（Class Interface），Java中经常使用的interface关键字定义的接口。</li>
 * </ol>
 * <br/>
 * 什么是隔离？
 * <ol>
 *     <li> Clients should not be forced to depend upon interfaces that they don't use.（客户端不应该依
 * 赖它不需要的接口。）</li>
 *     <li>The dependency of one class to another one should depend on the smallest possible interface.
 * （类间的依赖关系应该建立在最小的接口上。）</li>
 * <li>建立单一接口，不要建立臃肿庞大的接口。</li>
 * <li>接口尽量细化，同时接口中的方法尽量少。</li>
 * <li>单一职责要求的是类和接口职责单一，注重的是职责，这是业务逻辑上的划分</li>
 * <li>而接口隔离原则要 求接口的方法尽量少。</li>
 * </ol>
 * <br/>
 * 保证接口的纯洁性<br/>
 * <ol>
 *     <li> 接口要尽量小这是接口隔离原则的核心定义，不出现臃肿的接口（Fat Interface），但是“小”是有限度 的，首先就是不能违反单一职责原则，</li>
 *     <li>接口要高内聚:什么是高内聚？高内聚就是提高接口、类、模块的处理能力，减少对外的交互。</li>
 *     <li>定制服务:只提供访问者需要的方法，</li>
 *     <li>接口设计是有限度的</li>
 * </ol>
 * 接口隔离原则是对接口的定义，同时也是对类的定义，接口和类尽量使用原子接口或原
 * 子类来组装。但是，这个原子该怎么划分是设计模式中的一大难题，在实践中可以根据以下
 * 几个规则来衡量：
 * <ol>
 *     <li>一个接口只服务于一个子模块或业务逻辑；</li>
 *     <li>通过业务逻辑压缩接口中的public方法，接口时常去回顾，尽量让接口达到“满身筋骨 肉”，而不是“肥嘟嘟”的一大堆方法；</li>
 *     <li>已经被污染了的接口，尽量去修改，若变更的风险较大，则采用适配器模式进行转化
 * 处理；</li>
 *     <li>了解环境，拒绝盲从。每个项目或产品都有特定的环境因素，别看到大师是这样做的
 * 你就照抄。</li>
 *     <li></li>
 *     <li></li>
 * </ol>
 * @author MayZhou
 */
package principle.isp;