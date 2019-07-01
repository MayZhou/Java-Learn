package pattern.strategy.first;

/**
 * 封装类（也就是锦囊）
 * 其作用是承装三个策略，方便赵云 使用
 *
 * @author MayZhou
 */
public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    //使用计谋
    public void operate() {
        this.strategy.operate();
    }
}
