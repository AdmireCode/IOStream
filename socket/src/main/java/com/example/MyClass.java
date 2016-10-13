package com.example;

import java.net.InetAddress;
import java.util.Arrays;

public class MyClass {
    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());
        byte[] bytes = address.getAddress();//获取字节数组形式的IP地址
        System.out.println("字节数组形式的IP：" + Arrays.toString(bytes));
        System.out.println(address);//直接输出InetAddress对象

        System.out.println("============= 根据机器名获取InetAddress实例 ====================");
        InetAddress address1 = InetAddress.getByName("PC-20150322CTRI");
        System.out.println("计算机名：" + address1.getHostName());
        System.out.println("IP地址：" + address1.getHostAddress());

        System.out.println("============= 根据IP获取InetAddress实例 ====================");
        InetAddress address2 = InetAddress.getByName("192.168.1.116");
        System.out.println("计算机名：" + address2.getHostName());
        System.out.println("IP地址：" + address2.getHostAddress());
    }

}
