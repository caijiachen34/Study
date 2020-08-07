package com.kuang.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    //处理代理实例并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(rent,args);

        return result;
    }
}
