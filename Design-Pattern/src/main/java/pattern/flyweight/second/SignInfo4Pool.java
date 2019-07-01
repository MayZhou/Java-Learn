package pattern.flyweight.second;

/**
 * 带对象池的报考信息
 *
 *
 * ，就是增加了一个key值，为什么要增加key值？为什么要使用子类，而不在 SignInfo类上做修改？好，我来给你解释为什么要这样做，我们刚刚已经分析了所有的 SignInfo对象都有一些共同的属性：考试科目和考试地点，我们把这些共性提取出来作为所
 * 有对象的外部状态，在这个对象池中一个具体的外部状态只有一个对象。按照这个设计，我 们定义key值的标准为：考试科目+考试地点的复合字符串作为唯一的池对象标准，也就是说 在对象池中，一个key值唯一对应一个对象。
 * @author MayZhou
 */
public class SignInfo4Pool extends SignInfo {

    //定义一个对象池提取的KEY值
    private String key;
    //构造函数获得相同标志
    public SignInfo4Pool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
