package com.alun.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyDemo.class);
        enhancer.setCallback(new LogInterceptor());

        ProxyDemo proxyDemo = (ProxyDemo) enhancer.create();
        proxyDemo.a();
        proxyDemo.b();
    }
}
