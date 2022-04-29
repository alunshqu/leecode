package com.alun.bytecode;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        URL[] urls = {new URL("file:///D:/cassproject/leecode/leecode/src/main/java/com/alun/bytecode/")};
        Class clazz = new URLClassLoader(urls).loadClass("com.alun.bytecode.Student");
        Student student = (Student) clazz.newInstance();
        System.out.println(student.getAge());

    }
}
