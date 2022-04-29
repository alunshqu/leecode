package com.alun.bytecode;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyGeneratorClass extends ClassLoader{
    public Class getClassByBytes(byte[] bytes) {
        return defineClass(null, bytes, 0, bytes.length);
    }

    public byte[] createNewClass() {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "com/alun/bytecode/Student", null, "java/lang/Object", null);
        classWriter.visitField(Opcodes.ACC_PUBLIC, "age", "I", null, new Integer(11)).visitEnd();

        MethodVisitor init = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        init.visitCode();
        init.visitVarInsn(Opcodes.ALOAD, 0);
        init.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        init.visitInsn(Opcodes.RETURN);
        init.visitMaxs(1, 1);
        init.visitEnd();

        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "getAge", "()I", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, "com/alun/bytecode/Student", "age", "I");
        methodVisitor.visitInsn(Opcodes.IRETURN);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        MyGeneratorClass myGeneratorClass = new MyGeneratorClass();
        Class studentClass = myGeneratorClass.getClassByBytes(myGeneratorClass.createNewClass());

        Object student = studentClass.newInstance();
        Field field = studentClass.getField("age");
        Object age = field.get(student);
        Method getAge = studentClass.getMethod("getAge");
        Object result = getAge.invoke(student);

        System.out.println("Field age" + age);
        System.out.println("Method result" + result);
    }


}
