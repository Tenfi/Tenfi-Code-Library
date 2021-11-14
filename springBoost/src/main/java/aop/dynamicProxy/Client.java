package aop.dynamicProxy;


import aop.dynamicProxy.mdoel.House;
import aop.dynamicProxy.mdoel.HouseInterface;

public class Client {
    public static void main(String[] args) {
        HouseHandle houseHandle = new HouseHandle();
        houseHandle.setHouse(new House());
        HouseInterface proxy = houseHandle.getProxy();
        proxy.doRent();
    }
}
