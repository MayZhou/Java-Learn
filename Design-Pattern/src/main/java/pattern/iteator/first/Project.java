package pattern.iteator.first;

/**
 * @author MayZhou
 */
public class Project implements IProject {
    private String name = "";

    private int cost = 0;

    private int num = 0;

    public Project(String name, int num , int coat) {
        this.name = name;
        this.cost = coat;
        this.num = num;
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        //获得项目的名称
         info = info+ "项目名称是：" + this.name;
         //获得项目人数
         info = info + "\t项目人数: "+ this.num;
         //项目费用
         info = info+ "\t 项目费用："+ this.cost;
         return info;
    }
}
