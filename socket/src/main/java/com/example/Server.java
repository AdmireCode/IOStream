package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/10/14 0014.
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务端
 */
public class Server {
    public static void main(String[] args){
        try {
            //1、创建一个服务器端Socket，寄ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);//0~1023为系统所用

            System.out.println("*** 服务器即将启动，等待客户端的连接 ***");
            Socket socket = null;
            //记录客户端的数量
            int count = 0;
            //循环监听等待客户端的连接
            while(true){
                //2、调用accept()方法开始监听，等待客户端的连接
                socket = serverSocket.accept();//将进入阻塞状态，进行等待连接，并且返回一个Socket实例
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.setPriority(4);//设置线程的优先级，范围为[0,10],默认为5
                //启动线程
                serverThread.start();

                count++;//统计客户端的数量

                System.out.println("客户端的数量：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的ip：" + address.getHostAddress());
            }
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
