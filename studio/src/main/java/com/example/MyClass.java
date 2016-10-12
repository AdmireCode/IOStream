package com.example;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyClass {
    public static void main(String[] args){
        try {
        //=================== 字节流 ========================
            File f = new File("e:\\");
            File[] list = f.listFiles();
            System.out.println("file totle:" +  list.length);
        /*            long start = System.currentTimeMillis();
        FileInputUtil.printHex("e:\\AlanWalker.mp3");//单字节读取
        //FileInputUtil.printHexByByteArray("e:\\AlanWalker.mp3");//批量读取文件
        long end = System.currentTimeMillis();
        System.out.println(end - start);*/

        /*            FileOutputUtil.writeByte("e:\\out.txt");
        FileInputUtil.printHex("e:\\out.txt");

        FileInputUtil.copyFile(new File("e:\\out.txt"), new File("e:\\new.txt"));*/

        /*//DataOutputStream写入数据
        String fileName = "e:\\out.txt";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
        dos.writeInt(10);
        dos.writeInt(20);
        dos.writeInt(30);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //采用utf-8编码写出
        dos.writeUTF("中国");
        //采用utf-16的编码写出
        dos.writeChars("美国");
        dos.close();
        FileInputUtil.printHex(fileName);

        //DataInputStream读取数据
        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);*/

        /*//BufferedOutputStream拷贝数据
            BufferedOutputUtil.copyFileByBuff(new File("e:\\new.txt"), new File("e:\\1.txt"));*/

        //=================== 字符流 ========================
            FileInputStream in = new FileInputStream("e:\\test1.txt");
            InputStreamReader isr = new InputStreamReader(in,"gbk");
            FileOutputStream out  = new FileOutputStream("e:\\test1_out.txt");
            OutputStreamWriter osw = new OutputStreamWriter(out);
        /*
            int c;
            while((c = isr.read()) != -1){//默认按照gbk解析
            System.out.print((char) c);
        }*/
            char[] buffer = new char[8*1024];
            int c;
            //批量读取，放入buffer这个数组，从第0个位置开始放置，最多放buffer.length个
            //返回读到的字符个数
            while((c = isr.read(buffer, 0, buffer.length)) != -1){//c得到的是读取了多少个数，最后读完则会得到-1
                String s = new String(buffer, 0, c);
                System.out.print(s);
                osw.write(buffer, 0, c);
                osw.flush();//刷新缓存
            }
            isr.close();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

