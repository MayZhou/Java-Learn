package principle.lod.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法体内的Girl不属于朋友类
 * @author MayZhou
 */
public class Teacher {

    //老师对学生发布命令,清一下女生
    public void commond(GroupLeader groupLeader){
        List<Girl> listGirls = new ArrayList();
        //初始化女生
        for(int i=0;i<20;i++){
            listGirls.add(new Girl());
        }

        //告诉体育委员开始执行清查任务
        groupLeader.countGirls(listGirls);
    }
}
