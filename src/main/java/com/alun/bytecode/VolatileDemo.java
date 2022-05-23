package com.alun.bytecode;

import org.omg.CORBA.Object;

public class VolatileDemo {

    public static volatile String VOL = "demo";


    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(VOL);
            VOL = Thread.currentThread().getName();
            System.out.println(VOL);
        }).start();
        new Thread(() -> {
            System.out.println(VOL);
            VOL = Thread.currentThread().getName();
            System.out.println(VOL);
        }).start();
        new Thread(() -> {
            System.out.println(VOL);
            VOL = Thread.currentThread().getName();
            System.out.println(VOL);
        }).start();

        VolatileDemo volatileDemo = new VolatileDemo();
        Boolean flag = volatileDemo.getClass().isInstance(new Integer(10));
        System.out.println(flag);
    }
}
