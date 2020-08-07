package com.kuang.demo03;

import java.lang.reflect.InvocationHandler;

public class Client {
    public static void main(String[] args) {

        //真实角色
        Host host=new Host();

        //代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //通过调用程序处理角色来处理我们要调用的对象
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxy();

        proxy.rent();

    }
}