package com.alun.bytecode;

import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

public class MyAgent extends ClassLoader implements Opcodes {

    public static void main(String[] args) throws Exception{
        ClassReader classReader = new ClassReader("com/alun/bytecode/Student");

        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        ClassVisitor change = new ChangeVisitor(classWriter);
        classReader.accept(change, ClassReader.EXPAND_FRAMES);
        byte[] code = classWriter.toByteArray();

        MyGeneratorClass myGeneratorClass = new MyGeneratorClass();
        Class clazz = myGeneratorClass.getClassByBytes(code);
        /*FileOutputStream fileOutputStream = new FileOutputStream("D:\\cassproject\\leecode\\leecode\\src\\main\\java\\com\\alun\\bytecode\\Student.class");
        fileOutputStream.write(code);
        fileOutputStream.close();*/
        Thread.currentThread().setContextClassLoader(myGeneratorClass);
        Boolean flag = clazz.isInstance(Student.class);
        System.out.println(flag);
        System.out.println(clazz.getPackage());
        System.out.println();


        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getComponentType());
        System.out.println(Thread.currentThread().getContextClassLoader());

        Student student = new Student();
        System.out.println(student.getClass().getTypeName());
        System.out.println(student.getClass().getComponentType());
        System.out.println(student.getClass().getClassLoader());

        System.out.println(student.getAge());
        /*Object o = clazz.newInstance();
        if(o instanceof Student) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }*/
        /*Student student = new Student();
        System.out.println(student.getAge());
        Method method = clazz.getDeclaredMethod("getAge");
        System.out.println(method.invoke(o));*/


    }


    static class ChangeVisitor extends ClassVisitor {

        ChangeVisitor(ClassVisitor classVisitor) {
            super(ASM5, classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
            if(name.equals("<init>")) {
                return methodVisitor;
            }
            return new ChangeAdapter(ASM5, methodVisitor, access, name, desc);
        }

    }

    static class ChangeAdapter extends AdviceAdapter {

        private int startTimeId = -1;
        private String methodName = null;

        MethodVisitor methodVisitor;
        ChangeAdapter(int api, MethodVisitor mv, int access, String name, String desc) {
            super(api, mv, access, name, desc);
            methodName = name;
            methodVisitor = mv;
        }

        @Override
        protected void onMethodEnter() {
            super.onMethodEnter();
            startTimeId = newLocal(Type.LONG_TYPE);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            methodVisitor.visitIntInsn(LSTORE, startTimeId);
        }

        @Override
        protected void onMethodExit(int opcode) {
            super.onMethodExit(opcode);
            int durationId = newLocal(Type.LONG_TYPE);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            methodVisitor.visitVarInsn(LLOAD, startTimeId);
            methodVisitor.visitInsn(LSUB);
            methodVisitor.visitVarInsn(LSTORE, durationId);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitTypeInsn(NEW, "java/lang/StringBuilder");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            methodVisitor.visitLdcInsn("The Cost time of" + methodName + "() is");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            methodVisitor.visitVarInsn(LLOAD, durationId);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
            methodVisitor.visitLdcInsn(" ms");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        }
    }
}


