package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class ObjectSeriaDemo1 {
    public static void main(String[] args) throws Exception{
        String file = "e:\\obj.dat";
        //1、对象的序列化
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//        Student stu = new Student("1000", "张三", 20);
//        oos.writeObject(stu);
//        oos.flush();
//        oos.close();
//        objectOutStream(file);
        //2、通过反序列化的方式将文件e:\obj.dat读出来
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        Student stu1 = (Student) ois.readObject();
//        System.out.println(stu1);
        objectInputStream(file);


    }

    public static void objectOutStream(String file) throws Exception{
        //1、对象的序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("1000", "张三", 20);
        oos.writeObject(stu);
        oos.flush();
        oos.close();
    }
    public static void objectInputStream(String file) throws Exception{
        //2、通过反序列化的方式将文件e:\obj.dat读出来
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}
