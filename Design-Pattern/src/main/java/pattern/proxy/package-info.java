/**
 * 代理模式（Proxy Pattern）是一个使用率非常高的模式，其定义如下：
 * Provide a surrogate or placeholder for another object to control access to it.（为其他对象提供
 * 一种代理以控制对这个对象的访问。）
 *
 * 代理模式也叫做委托模式，它是一项基本设计技巧。许多其他的模式，如状态模式、策
 * 略模式、访问者模式本质上是在更特殊的场合采用了委托模式，而且在日常的应用中，代理 模式可以提供非常好的访问控制。在一些著名开源软件中也经常见到它的身影，如Struts2的 Form元素映射就采用了代理模式（准确地说是动态代理模式）。我们先看一下类图中的三个
 * 角色的定义：
 * ● Subject抽象主题角色
 * 抽象主题类可以是抽象类也可以是接口，是一个最普通的业务类型定义，无特殊要求。
 * ● RealSubject具体主题角色
 * 也叫做被委托角色、被代理角色
 *
 * 代理模式的优点
 * ● 职责清晰
 * 真实的角色就是实现实际的业务逻辑，不用关心其他非本职责的事务，通过后期的代理
 * 完成一件事务，附带的结果就是编程简洁清晰。
 * ● 高扩展性
 * 具体主题角色是随时都会发生变化的，只要它实现了接口，甭管它如何变化，都逃不脱
 * 如来佛的手掌（接口），那我们的代理类完全就可以在不做任何修改的情况下使用。
 * ● 智能化
 * 这在我们以上的讲解中还没有体现出来，不过在我们以下的动态代理章节中你就会看到 代理的智能化有兴趣的读者也可以看看Struts是如何把表单元素映射到对象上的。
 * 看Spring AOP，这是一个非常典型的动态代理。
 * 代理是有个性的
 * 一个类可以实现多个接口，完成不同任务的整合。也就是说代理类不仅仅可以实现主题
 * 接口，也可以实现其他接口完成不同的任务，而且代理的目的是在目标对象方法的基础上作
 * 增强，这种增强的本质通常就是对目标对象的方法进行拦截和过滤。例如游戏代理是需要收 费的，升一级需要5元钱，这个计算功能就是代理类的个性，
 * @author MayZhou
 */
package pattern.proxy;