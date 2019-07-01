package pattern.decorator.second;

/**
 * @author MayZhou
 */
public class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport {
    private void reportHighestScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    private void reportSort() {
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report() {
        this.reportHighestScore();  //先说最高成绩
         super.report();  //然后老爸看成绩单
         this.reportSort(); //然后告诉老爸学习学校排名
    }
}
