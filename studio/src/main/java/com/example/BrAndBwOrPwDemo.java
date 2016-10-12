package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("e:\\utf-8.txt")));
        //InputStreamReader构造是有字符编码，所以在new InputStreamReader(new FileInputStream("e:\\test2.txt"),"gdk")可以附带编码格式
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("e:\\test3.txt")));
        //用PrintWriter 比用BuffereWriter会更简单一些
        PrintWriter pw = new PrintWriter("e:\\test4.txt");


        String line;
        //while ((r = br.read()) != -1){//一次读一个
        while ((line = br.readLine()) != null){//一次读一行，只要读到null就表示结束
            System.out.println(line);//一次读一行，并不能识别换行
/*            bw.write(line);
            bw.newLine();//换行操作
            bw.flush();*/
            pw.println(line);//直接包括了换行操作
            pw.flush();
        }
        br.close();
//        bw.close();
        pw.close();
    }
}
