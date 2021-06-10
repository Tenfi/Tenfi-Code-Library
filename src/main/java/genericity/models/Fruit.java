package genericity.models;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/9 14:23
 */
public class Fruit extends Food{
    private int num;

    public Fruit(String name, int num) {
        super(name);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
