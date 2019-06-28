/**
 * 在面向对象的语言中，继承是必不可少的、非常优秀的语言机制，它有如下优点
 * <ol >
 * <li>代码共享，减少创建类的工作量，每个子类都拥有父类的方法和属性；</li>
 * <li>提高代码的重用性；</li>
 * <li>子类可以形似父类，但又异于父类，“龙生龙，凤生凤，老鼠生来会打洞”是说子拥有 父的“种”，“世界上没有两片完全相同的叶子”是指明子与父的不同；</li>
 * <li>提高代码的可扩展性，实现父类的方法就可以“为所欲为”了，君不见很多开源框架的扩展接口都是通过继承父类来完成的；</li>
 * <li>提高产品或项目的开放性。</li>
 * </ol>
 * 缺点
 * <ol>
 * <li> 继承是侵入性的。只要继承，就必须拥有父类的所有属性和方法；</li>
 * <li>降低代码的灵活性。子类必须拥有父类的属性和方法，让子类自由的世界中多了些约束；</li>
 * <li>增强了耦合性。当父类的常量、变量和方法被修改时，需要考虑子类的修改，而且在 缺乏规范的环境下，这种修改可能带来非常糟糕的结果——大段的代码需要重构。</li>
 * </ol>
 * 里氏替换
 * <ol>
 * <li>（如果对每一个类型为S的对象o1，都有类型为T的对 象o2，使得以T定义的所有程序P在所有的对象o1都代换成o2时，程序P的行为没有发生变 化，那么类型S是类型T的子类型。</li>
 * <li>所有引用基类的地方必须能透明地使用其子类的对象。</li>
 * <li>通俗点讲，只要父类能出现的地方子类就可以出现，而且替换为子类也不会产生任何错误或异常，使用者可能根本就不需要知道是父类还是子类。但是，反过来就不行了，有子类出现的地方，父类未必就能适应。</li>
 * <li>子类可以扩展父类的功能，但不能改变父类原有的功能。也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。</li>
 * <li>.覆盖或实现父类的方法时输入参数可以被放大</li>
 * <li>如果Father类的输入参数类型宽于子类的输入参数类型，会出现什么问题呢？会出现父类存在的地方，子类就未必可以存在，因为一旦把子类作为参数传入，调用者就很可能进入 子类的方法范畴。</li>
 * <li>如果子类的参数范围比父类小，调用了子类的方法，</li>
 * <ol><li>重载，方法名相同，参数不同，和重写不一样</li>
 * <li>子类在没有覆写父类的方法的前提下，子类方法被执行了</li>
 * </ol></li>
 *
 * <li>覆写或实现父类的方法时输出结果可以被缩小</li>
 *
 * </ol>
 * 注意
 * <ol>
 * <li>在类中调用其他类时务必要使用父类或接口，如果不能使用父类或接口，则说明 类的设计已经违背了LSP原则。</li>
 * <li>如果子类不能完整地实现父类的方法，或者父类的某些方法在子类中已经发 生“畸变”，则建议断开父子继承关系，采用依赖、聚集、组合等关系代替继承。</li>
 * <li>这个包里面的例子，个人感觉有问题，shoot()方法在不同的实现类中程序的业务逻辑发生了变化</li>、
 * <li></li>
 * </ol>
 *
 * 采用里氏替换原则的目的就是增强程序的健壮性，版本升级时也可以保持非常好的兼容
 * 性。即使增加子类，原有的子类还可以继续运行。在实际项目中，每个子类对应不同的业务
 * 含义，使用父类作为参数，传递不同的子类完成不同的业务逻辑，非常完美！
 *
 * 在项目中，采用里氏替换原则时，尽量避免子类的“个性”，一旦子类有“个性”，这个子 类和父类之间的关系就很难调和了，把子类当做父类使用，子类的“个性”被抹杀——委屈了 点；把子类单独作为一个业务来使用，则会让代码间的耦合关系变得扑朔迷离——缺乏类替
 * 换的标准。
 * @author MayZhou
 */
package principle.lsp;