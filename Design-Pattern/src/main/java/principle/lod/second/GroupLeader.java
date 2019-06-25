package principle.lod.second;

import principle.lod.first.Girl;

import java.util.List;

/**
 * @author MayZhou
 */
public class GroupLeader {
    private List<Girl> girlList;

    public GroupLeader(List<Girl> girlList) {
        this.girlList = girlList;
    }

    //有清查女生的工作
    public void countGirls(List<Girl> listGirls){
        this.girlList = listGirls;
    }
    //清查女生数量
    public void countGirls(){
     System.out.println("女生数量是："+this.girlList.size());     }
}
