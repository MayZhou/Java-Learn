package principle.lsp.fourth.ext;

import principle.lsp.first.abstr.ext.Rifle;

/**
 * @author MayZhou
 */
public class AUG extends Rifle {
    //狙击枪都携带一个精准的望远镜
    public void zoomOut() {
        System.out.println("通过望远镜察看敌人...");
    }
}
