package aop.dynamicProxy;

import aop.dynamicProxy.mdoel.HouseInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HouseHandle implements InvocationHandler {
    private HouseInterface house;

    public void setHouse(HouseInterface house) {
        this.house = house;
    }

    public HouseInterface getProxy() {
        return (HouseInterface) Proxy.newProxyInstance(house.getClass().getClassLoader(), house.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("租房前");
        Object result = method.invoke(house, args);
        System.out.println("租房后");
        return result;
    }
}
