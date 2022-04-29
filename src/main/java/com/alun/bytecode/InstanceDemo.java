package com.alun.bytecode;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InstanceDemo {

    public static void main(String[] args) throws Exception{
        MyGeneratorClass myGeneratorClass = new MyGeneratorClass();
        MyGeneratorClass myGeneratorTargetClass = new MyGeneratorClass();
        File fileSource = new File("D:\\cassproject\\leecode\\leecode\\src\\main\\java\\com\\alun\\bytecode\\Student.class");
        File fileTarget = new File("D:\\cassproject\\leecode\\leecode\\target\\classes\\com\\alun\\bytecode\\Student.class");
        byte[] dataSourceByte;
        byte[] dataTargetByte;
        Path path = Paths.get(new URI("file:///D:/cassproject/leecode/leecode/src/main/java/com/alun/bytecode/Student.class"));
        Path pathTarget = Paths.get(new URI("file:///D:/cassproject/leecode/leecode/target/classes/com/alun/bytecode/Student.class"));
        dataSourceByte = Files.readAllBytes(path);
        dataTargetByte = Files.readAllBytes(pathTarget);
        Class clazzSource = myGeneratorClass.getClassByBytes(dataSourceByte);
        Class clazzTarget = myGeneratorClass.getClassByBytes(dataSourceByte);

        System.out.println(clazzSource.isInstance(clazzTarget));
    }
}
