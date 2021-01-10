package com.oracle.jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作业2
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
 * Created by xfx on 2021/1/10 15:26
 * @author 86134
 */
public class MyClassLoaderFile extends ClassLoader {
    private static String url = "E:\\学习\\极客学习\\java进阶训练营\\homework\\JAVA-01\\Week_01\\src\\com\\oracle\\jvm\\Hello.xlass";
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1.加载文件
        Class<?> cls = new MyClassLoaderFile().findClass("Hello");
        //2.执行方法
        Method method = cls.getDeclaredMethod("hello");
        method.invoke(cls.newInstance());
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = readFile(url);
        return defineClass(name, bytes, 0, bytes.length);
    }
    private byte[] readFile(String url) {
        File file = new File(url);
        byte[] bytes = null;
        try {
            InputStream inputStream = new FileInputStream(file);
            bytes = getDecodeBytes(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
    private byte[] getDecodeBytes(InputStream inputStream) throws IOException {
        byte[] srcBytes = new byte[inputStream.available()];
        inputStream.read(srcBytes);
        byte[] bytes = new byte[srcBytes.length];
        for (int i = 0; i < srcBytes.length; i++) {
            bytes[i] = (byte) (255 - srcBytes[i]);
        }
        return bytes;
    }
}
