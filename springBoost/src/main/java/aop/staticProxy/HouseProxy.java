package aop.staticProxy;

import aop.staticProxy.mdoel.HouseInterface;

public class HouseProxy implements HouseInterface {
    private HouseInterface house;

    public void setHouse(HouseInterface house) {
        this.house = house;
    }

    @Override
    public void doRent() {
        System.out.println("租房前");
        house.doRent();
        System.out.println("租房后");
    }
}
