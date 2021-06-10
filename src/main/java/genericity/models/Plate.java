package genericity.models;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/9 14:22
 */
public class Plate<T> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "item=" + item +
                '}';
    }
}
