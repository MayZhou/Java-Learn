package principle.ocp.first;

/**
 * @author MayZhou
 */
public class NovelBook implements IBook {
    //书籍名称
    private String name;
    //书籍的价格
    private int price;
    //书籍的作者
    private String author;


    public NovelBook(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getAuthor() {
        return this.author;
    }
}
