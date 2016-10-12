package com.example;
        
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.nio.ch.IOUtil;
        
/**
  * Created by Administrator on 2016/9/12 0012.
  */
public class FileOutputUtil {
        public static void writeByte(String fileName) throws IOException {
                //如果该文件不存在，则直接创建，如果存在，删除后创建
                FileOutputStream out = new FileOutputStream(fileName);
                out.write('A');//写入‘A’的低八位
                out.write('B');//写入‘B’的低八位
                int a = 10;
                out.write(a >>> 24);//无符号右移0xffff
                out.write(a >>> 16);
                out.write(a >>> 8);
                out.write(a);
                byte[] gbk = "中国".getBytes("gbk");
                out.write(gbk);
                out.close();
        }
}

