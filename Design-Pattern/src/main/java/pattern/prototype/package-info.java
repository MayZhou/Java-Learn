/**
 * ，把对象复制一份，产生一个新的
 * 对象，和原有对象一样，然后再修改细节的数据，如设置称谓、设置收件人地址等。这种不 通过new关键字来产生一个对象，而是通过对象复制来实现的模式就叫做原型模式。{@link pattern.prototype.second.Client}
 * 实现一个接口，然后重写clone方法，就完成了原型模式！
 * 优点
 * <ol>
 *     <li>性能优良
 * 原型模式是在内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一
 * 个循环体内产生大量的对象时，原型模式可以更好地体现其优点。</li>
 *     <li>逃避构造函数的约束
 * 这既是它的优点也是缺点，直接在内存中拷贝，构造函数是不会执行的（参见13.4
 * 节）。优点就是减少了约束，缺点也是减少了约束，需要大家在实际应用时考虑。</li>
 * </ol>
 * <使用场景
 * <ol>
 *     <li>资源优化场景
 * 类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。</li>
 * <li>性能和安全要求的场景
 * 通过new产生一个对象需要非常繁琐的数据准备或访问权限，则</li>
 * <li>一个对象多个修改者的场景
 * 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑
 * 使用原型模式拷贝多个对象供调用者使用。</li>
 * <li>在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone的 方法创建一个对象，然后由工厂方法提供给调用者。原型模式已经与Java融为一体，大家可
 * 以随手拿来使用。</li>
 * <li>使用原型模式时，引用的成员变量必须满足两个条件才不会被拷贝：一是类的成
 * 员变量，而不是方法内变量；二是必须是一个可变的引用对象，而不是一个原始类型或不可
 * 变对象。</li>
 * </ol>
 * 限制
 * <ol>
 *     <Li> 构造函数不会被执行</Li>
 *     <Li>Object类提供 的方法clone只是拷贝本对象，其对象内部的数组、引用对象等都不拷贝，还是指向原生对象
 * 的内部元素地址，这种拷贝就叫做浅拷贝。确实是非常浅，两个对象共享了一个私有变量，
 * 你改我改大家都能改，是一种非常不安全的方式，在实际项目中使用还是比较少的（当然， 这也是一种“危机”环境的一种救命方式）。</Li>
 * <li>浅拷贝的意思是成员变量（满足上一条的）是不会被复制的，只会在原对象上的成员变量上操作</li>
 *     <Li></Li>
 * </ol>
 * @author MayZhou
 */
package pattern.prototype;