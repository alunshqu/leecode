package com.alun.nativedemo;

public class NativeDemo {
    static {
        //System.loadLibrary("hello");
        System.load("D:/cassproject/leecode/leecode/src/main/java/com/alun/nativedemo/hello.dll");
    }

    public static void main(String[] args) {
        new NativeDemo().sayHello();
    }

    private native void sayHello();

    //two diff date
    public void diffDate(){

    }



}
