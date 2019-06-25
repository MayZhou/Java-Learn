package principle.lod.second;

/**
 * 方法体内的Girl不属于朋友类
 * @author MayZhou
 */
public class Teacher {

    //老师对学生发布命令,清一下女生
    public void commond(GroupLeader groupLeader){
        //告诉体育委员开始执行清查任务
        groupLeader.countGirls();
    }
}
