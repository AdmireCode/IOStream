
package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* Created by Administrator on 2016/9/19 0019.
*/
public class BufferedOutputUtil {

/**
* 进行文件的拷贝，利用带缓冲的字节流
* @param srcFile
* @param destFile
* @throws IOException
*/
public static void copyFileByBuff(File srcFile, File destFile) throws IOException {
if(!srcFile.exists()){
        throw new IllegalArgumentException("文件：" + srcFile + "不存在");
    }
if(!srcFile.isFile()){
        throw new IllegalArgumentException(srcFile + "不是文件");
    }
BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
int c;
while((c = bis.read()) != -1){
        bos.write(c);
        bos.flush();//刷新缓冲区
    }
bis.close();
bos.close();

    }

/**
* 单字节拷贝数据
* @param srcFile
* @param destFile
* @throws IOException
*/
public static void copyFileByByte(File srcFile, File destFile)throws IOException{
if(!srcFile.exists()){
        throw new IllegalArgumentException("文件：" + srcFile + "不存在");
    }
if(!srcFile.isFile()){
        throw new IllegalArgumentException(srcFile + "不是文件");
    }
FileInputStream in = new FileInputStream(srcFile);
FileOutputStream out = new FileOutputStream(destFile);
int c;
while((c = in.read()) != -1){
        out.write(c);
        out.flush();
    }
in.close();
out.close();
}
}

