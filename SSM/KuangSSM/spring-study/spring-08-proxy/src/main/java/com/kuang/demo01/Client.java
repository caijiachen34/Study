package com.kuang.demo01;

import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        //代理
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
