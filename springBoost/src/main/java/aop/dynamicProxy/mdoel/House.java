package aop.dynamicProxy.mdoel;

public class House implements HouseInterface {
    @Override
    public void doRent() {
        System.out.println("要出租房子！");
    }
}
