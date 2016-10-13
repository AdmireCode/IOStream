package com.example;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/13 0013.
 * URL使用
 */
public class Test02 {
    public static void main(String[] args){
        try {
            //URL参数相关内容在《Java遇见HTML---jsp篇》中，有详细介绍
            //创建一个URL实例
            URL imooc = new URL("http://www.imooc.com");
            URL url = new URL(imooc, "/index.html?username=tom#test");//通过URL获得一个URL实例//?后面表示参数，#后面表示锚点
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            //如果未指定端口号，则使用默认的端口号，此时getPort()方法返回值为-1
            System.out.println("端口：" + url.getPort());
            System.out.println("文件路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("相对路径：" + url.getRef());
            System.out.println("查询字符串：" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
