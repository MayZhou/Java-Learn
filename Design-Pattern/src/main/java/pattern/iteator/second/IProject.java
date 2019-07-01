package pattern.iteator.second;

/**
 * @author MayZhou
 */
public interface IProject {
    String getProjectInfo();
    void add(String name,int num,int cost);

    IProjectIterator iterator();
}

