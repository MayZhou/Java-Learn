/**
 * 迭代器模式
 *
 * 迭代器模式（Iterator Pattern）目前已经是一个没落的模式，基本上没人会单独写一个迭
 * 代器，除非是产品性质的开发，其定义如下：
 * Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.（它提供一种方法访问一个容器对象中各个元素，而又不需暴露该
 * 对象的内部细节。）
 *
 * 迭代器是为容器服务的，那什么是容器呢？ 能容纳对象的所有类型都可以称之为容 器
 * 迭代器模式提供了遍历容器的方便性，容器只要管理增减元素就可以了，需要遍历时交
 * 由迭代器进行。
 *
 * java语言不需要自己写迭代器
 * @author MayZhou
 */
package pattern.iteator;