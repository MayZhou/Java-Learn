package pattern.mediator.second;

/**
 * 采购管理
 *
 * @author MayZhou
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator _mediator) {
        super(_mediator);
    }

    //采购IBM电脑
    public void buyIBMcomputer(int number) {
        super.mediator.exectute("purchase.buy",number);
    }
    //不再采购IBM电脑

    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }
}

