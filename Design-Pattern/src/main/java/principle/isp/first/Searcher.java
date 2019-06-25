package principle.isp.first;

/**
 * @author MayZhou
 */
public class Searcher extends AbstractSearcher {
    public Searcher(IPettyGirl pettyGirl) {

        super(pettyGirl);
    }

    public void show() {
        System.out.println("--------美女的信息如下：---------------");
        //展示面容
        super.pettyGirl.goodLooking();
        // 展示身材
        super.pettyGirl.niceFigure();
        // 展示气质
        super.pettyGirl.greatTemperament();


    }
}
