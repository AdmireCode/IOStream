package com.example;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class Student implements Serializable{
    private String stuno;
    private String stuname;
//    ArrayList
    private transient int stuage;//加transient关键字后，该元素不会进行jvm默认的序列化，为了如果有些数据不必下载这样可以节省流量，但也可以
    //自己完成这个元素的序列化

    public Student(){
    }

    public Student(String stuno, String stuname, int stuage) {
        super();
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public String getStuno() {

        return stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public int getStuage() {
        return stuage;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        // Write out element count, and any hidden stuff
        s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
        s.writeInt(stuage);
    }
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {

        // Read in size, and any hidden stuff
        s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作

        // Read in capacity
        this.stuage = s.readInt(); // ignored
    }



    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }
}
