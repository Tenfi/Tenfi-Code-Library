package genericity.tests;

import genericity.models.Apple;
import genericity.models.Food;
import genericity.models.Fruit;
import genericity.models.Plate;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/9 14:25
 */
public class extendsAndSuperTest {
    public static void doSetAndGet(Plate<? extends Fruit> plate) {
        // extends 无法使用set，因为不确定子类的类型
//         plate.setItem(new Apple("苹果",999));
        System.out.println("盘子里装的是：" + plate.getItem());
    }

    public static void main(String[] args) {
        Food food = new Food("食物");
        Fruit fruit = new Fruit("水果", 1);
        Apple apple = new Apple("苹果", 1);

        // 将T声明为父类，默认可以存放自己及其子类示例,不能放自己的父类
        // Plate<Fruit> plate0 =new Plate<>(food);
        Plate<Fruit> plate1 = new Plate<>(fruit);
        Plate<Fruit> plate2 = new Plate<>(apple);

        doSetAndGet(plate1);
        doSetAndGet(plate2);
    }
}
