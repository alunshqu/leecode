package com.alun.proxy;

public class ProxyDemo implements ProxyInterface{

    @Override
    public void a() {
        System.out.println("A");
        b();
    }

    @Override
    public void b() {
        System.out.println("B");
    }
}
