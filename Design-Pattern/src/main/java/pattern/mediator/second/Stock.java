package pattern.mediator.second;

/**
 * 库存
 *
 * @author MayZhou
 */
public class Stock extends AbstractColleague {
    private static int COMPUTER_NUMBER = 100;

    public Stock(AbstractMediator _mediator) {
        super(_mediator);
    }

    //增加库存
    public void increase(int number) {
        COMPUTER_NUMBER = COMPUTER_NUMBER + number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }

    //降低库存
    public void decrease(int number) {
        COMPUTER_NUMBER = COMPUTER_NUMBER - number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }

    //查询库存
    public int getStockNumber() {
        return COMPUTER_NUMBER;
    }

    //库存压力大，建议采购人员不要采购，销售人员尽快销售
    public void clearStock() {
        super.mediator.exectute("stock.clear");
        System.out.println("清理存货数量为：" + COMPUTER_NUMBER);


    }
}
