package pattern.iteator.second;

import java.util.ArrayList;

/**
 * @author MayZhou
 */
public class ProjectIterator implements IProjectIterator {

    private ArrayList<IProject> projectList ;

    private int currentItem = 0;

    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        boolean b =true;
        if(this.currentItem >= projectList.size() || this.projectList.get(this.currentItem) == null){
            b = false;
        }
        return b;
    }


    @Override
    public IProject next() {
        return (IProject)this.projectList.get(this.currentItem++);
    }


    @Override
    public void remove() {

    }
}
