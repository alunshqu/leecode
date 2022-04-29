package com.alun.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始代理" + method.getName());
        Object o = methodProxy.invokeSuper(obj, objects);
        System.out.println("结束代理");
        return o;
    }
}
