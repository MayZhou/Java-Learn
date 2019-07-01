package pattern.decorator.second;

/**
 * 通过继承确实能够解决这个问题，老爸看成绩单很开心，然后就给签字了，但现实的情
 * 况是很复杂的，可能老爸听我汇报最高成绩后，就直接乐开花了，直接签名了，后面的排名
 * 就没必要看了，或者老爸要先看排名情况，那怎么办？继续扩展？你能扩展多少个类？这还 是一个比较简单的场景，一旦需要装饰的条件非常多，比如20个，你还通过继承来解决，你
 * 想象的子类有多少个？你是不是马上就要崩溃了！
 * @author MayZhou
 */
public class Father {
    public static void main(String[] args) {

        //把成绩单拿过来
        SchoolReport sr = new SugarFouthGradeSchoolReport();
        //看成绩单
        sr.report();
        sr.sign("老三");
    }
}
