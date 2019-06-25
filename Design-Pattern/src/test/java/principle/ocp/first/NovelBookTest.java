package principle.ocp.first;


import junit.framework.TestCase;



/**
 * @author MayZhou
 */

public class NovelBookTest extends TestCase {
    private String name = "平凡的世界";
    private int price = 6000;
    private String author = "路遥";
    private IBook novelBook = new NovelBook(name, price, author);


    //方法名必须以test开头
    public void testGetPrice() {
        super.assertEquals(this.price,this.novelBook.getPrice());
    }
}
