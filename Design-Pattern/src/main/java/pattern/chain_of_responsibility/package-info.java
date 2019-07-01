/**
 * 责任链模式定义如下：
 * Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.Chain the receiving objects and pass the request along the chain until an object handles it.（使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关
 * 系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。）
 *
 * 责任链模式的重点是在“链”上，由一条链去处理相似的请求在链中决定谁来处理这个请 求，并返回相应的结果，
 * @author MayZhou
 */
package pattern.chain_of_responsibility;