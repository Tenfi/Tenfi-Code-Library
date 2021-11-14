package aop.staticProxy;

import aop.staticProxy.mdoel.House;

public class Client {
    public static void main(String[] args) {
        HouseProxy houseProxy = new HouseProxy();
        houseProxy.setHouse(new House());
        houseProxy.doRent();
    }
}
