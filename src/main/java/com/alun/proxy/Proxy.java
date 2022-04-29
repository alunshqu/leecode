package com.alun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {

    public static void main(String[] args) {
        ProxyInterface proxyInterfaceTobeProxy = new ProxyDemo();

        ProxyInterface proxyInterface = (ProxyInterface)java.lang.reflect.Proxy.newProxyInstance(
                proxyInterfaceTobeProxy.getClass().getClassLoader(),
                proxyInterfaceTobeProxy.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理方法执行");
                        Object object = method.invoke(proxyInterfaceTobeProxy, args);
                        return object;
                    }
                });

        proxyInterface.a();
        proxyInterface.b();
    }
}
