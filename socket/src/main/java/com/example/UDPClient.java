package com.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/10/14 0014.
 * 客户端
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        /*
        向服务器端发送数据
         */
        //1、定义服务器的地址、端口号、数据
        InetAddress address = InetAddress.getByName("PC-20150322CTRI");
        int prot = 8800;
        byte[] data = "用户名：admin；密码：123".getBytes();
        //2、创建数据报，包含发送的数据信息
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, prot);
        //3、创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4、向服务器端发送数据报
        socket.send(datagramPacket);

        /*
        接收服务器端响应的数据
         */
        //1、创建数据报，用于接收服务器端响应的数据
        byte[] data2 = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(data2,data2.length);
        //2、接收服务器响应的数据
        socket.receive(datagramPacket1);
        //3、读取数据
        String reply = new String(data2, 0, datagramPacket1.getLength());
        System.out.println("我是客户端，服务端说：" + reply);
        //4、关闭资源
        socket.close();
    }
}
