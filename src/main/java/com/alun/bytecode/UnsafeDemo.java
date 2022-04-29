package com.alun.bytecode;

import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnsafeDemo {

    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        byte[] sourceBuffer = Files.readAllBytes(Paths.get(new URI("file:///D:/cassproject/leecode/leecode/src/main/java/com/alun/bytecode/Student.class")));
        byte[] targetBuffer = Files.readAllBytes(Paths.get(new URI("file:///D:/cassproject/leecode/leecode/target/classes/com/alun/bytecode/Student.class")));

        /*Class sourceClazz = unsafe.defineClass("com.alun.bytecode.Student", sourceBuffer, 0, sourceBuffer.length, ClassLoader.getSystemClassLoader(), null);
        Class targetClazz = unsafe.defineClass("com.alun.bytecode.Student", targetBuffer, 0, targetBuffer.length, ClassLoader.getSystemClassLoader(), null);
*/
        Class sourceClazz = unsafe.defineAnonymousClass(Student.class, sourceBuffer, null);
        Class targetClazz = unsafe.defineAnonymousClass(Student.class, targetBuffer, null);

        /*System.out.println(sourceBuffer.getClass().getDeclaredConstructor().getName());
        System.out.println(targetClazz.getClass().getDeclaredConstructor().getName());*/
        System.out.println(sourceClazz.isInstance(targetClazz));
    }

}
