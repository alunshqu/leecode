package com.alun.bytecode;

public class Student {

    public int age;

    public Student(){}

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public int[] getAges() {
        return new int[10];
    }

    public Student getStudent() {
        return this;
    }

}
