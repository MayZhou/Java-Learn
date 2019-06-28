package pattern.factory.factorymethod.first;

/**
 * @author MayZhou
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human =null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        }catch (ClassNotFoundException e){
            System.out.println("人种生成错误！");
        } catch (IllegalAccessException e) {
            System.out.println("人种生成错误！");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("人种生成错误！");
            e.printStackTrace();
        }
        return (T) human;
    }
}
