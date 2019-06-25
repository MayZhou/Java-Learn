package principle.isp.first;

/**
 * @author MayZhou
 */
public class Client {
    public static void main(String[] args) {
        //定义一个美女
        IPettyGirl yanYan = new PettyGirl("嫣嫣");
        AbstractSearcher searcher = new Searcher(yanYan);
        searcher.show();
    }
}
