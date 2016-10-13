package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/13 0013.
 * 使用URL读取页面内容
 */
public class Test03 {
    public static void main(String[] agr){
        //创建一个URL实例
        try {
            URL url = new URL("http://www.baidu.com");
            //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream is = url.openStream();
            //通过字节输入流转换成字符输入流
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data;
            while((data = br.readLine()) != null){//读取数据，一次读取一行
                System.out.println(data);
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
