package pattern.decorator.third;

/**
 * @author MayZhou
 */
public class Father {
    public static void main(String[] args) {

        //原装成绩单拿过来
        SchoolReport sr = new FouthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);
        sr =new SortDecorator(sr);
        //看成绩单
        sr.report();
        //签名？休想！
        sr.sign("ss");
    }
}
