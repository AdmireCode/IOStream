package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2016/10/14 0014.
 * 客户端
 */
public class Client {
    public static void main(String[] args){
        try {
            //1、创建客户端Socket，指定服务端端口
            Socket socket = new Socket("PC-20150322CTRI",8888);
            //2、获取输出流，向服务端发送信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admain； 密码：123");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3、获取输入流，并读取服务端的响应信息
            InputStream is = socket.getInputStream();//字节输入流
            InputStreamReader isr = new InputStreamReader(is);//将字节流转换为字符输入流
            BufferedReader br = new BufferedReader(isr);//为字符输入流添加缓冲
            String info = null;
            while ((info = br.readLine()) != null){
                System.out.println("我是客户端，服务器说：" + info);
            }
            socket.shutdownInput();//关闭输入流
            //4、关闭相关资源
            br.close();
            isr.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
