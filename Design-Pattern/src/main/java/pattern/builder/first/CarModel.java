package pattern.builder.first;

import java.util.ArrayList;

/**
 * @author MayZhou
 */
public abstract class CarModel {
    //这个参数是各个基本方法执行的顺序
    private ArrayList<String> sequence = new ArrayList<String>();
    /**
     * 首先，这个模型要能够被发动起来，别管是手摇发动，还是电力发动，反正      * 是要能够发动起来，那这个实现要在实现类里了
     */
    protected abstract void start();

    //能发动，还要能停下来，那才是真本事
    protected abstract void stop();

    //喇叭会出声音，是滴滴叫，还是哔哔叫
    protected abstract void alarm();

    //引擎会轰隆隆地响，不响那是假的
    protected abstract void engineBoom();
    public final void run(){
        //循环一边，谁在前，就先执行谁
        for(int i=0;i<this.sequence.size();i++){
            String actionName = this.sequence.get(i);

            if(actionName.equalsIgnoreCase("start")){  //如果是start关键字，
                this.start();  //开启汽车
            }else if(actionName.equalsIgnoreCase("stop")){ //如果是stop关键字
                this.stop(); //停止汽车
            }else if(actionName.equalsIgnoreCase("alarm")){ //如果是alarm关键字
                this.alarm(); //喇叭开始叫了
            }else if(actionName.equalsIgnoreCase("engine boom")){  //如果是engine boom关键字
                this.engineBoom();  //引擎开始轰鸣
            }

        }
    }
    final public void setSequence(ArrayList sq){
        this.sequence = sq;
    }
}
