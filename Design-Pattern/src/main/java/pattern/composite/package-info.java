/**
 * 组合模式
 * 组合模式(Composite Pattern)也叫合成模式，有时又叫做部分-整体模式（Part-Whole），
 * 主要是用来描述部分与整体的关系，其定义如下：
 * Compose objects into tree structures to represent part-whole hierarchies.Composite lets clients treat individual objects and compositions of objects uniformly.（将对象组合成树形结构以表 示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。）
 * 只要是树形结构，就要考虑使用组合模式，这个一定要记住，只要是要体现局部和整体
 * 的关系的时候，而且这种关系还可能比较深，考虑一下组合模式吧。
 *
 *
 * 例子：数据库的单表树结构
 * @author MayZhou
 */
package pattern.composite;