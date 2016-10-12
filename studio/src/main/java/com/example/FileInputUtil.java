
package com.example;
        
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
        
/**
* Created by Administrator on 2016/9/12 0012.
*//**
 * Created by Administrator on 2016/9/12 0012.
 */
public class FileInputUtil {

    /**
    * 读取指定文件内容，按照16进制输入到控制台
    * 并且没输出10个byte换行
    * @param fileName
    * @throws IOException
    * 单字节读取不适合大文件，大文件效率很低
    */
    public static void printHex(String fileName) throws IOException{
        //把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while((b = in.read()) != -1){
            if(b <= 0xf){
                //单位前面补零
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if(i %10 == 0){
                System.out.println();
            }
        }
        in.close();
    }
    /**
      * 批量读取 适合读取大文件 效率高，也是常用的方式
      * @param fileName
      * @throws IOException
      */
    public static void printHexByByteArray(String fileName)throws IOException{//批量读取数据
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[20 * 1024];
        //从in中批量读取字节，放到buf这个字节数组中，从第0个位置开始放，
                // 最多放buf.length个 返回的是独到的自己的个数
        //方法一
        /*        int bytes = in.read(buf, 0, buf.length);//一次性读完，说明字节数组足够大
        int j = 1;
        for(int i = 0; i < bytes; i){
        if(buf[i] <= 0xf){//如果是一个数的时候前面补零
        System.out.print("0");
        }
        System.out.print(Integer.toHexString(buf[i])  " ");
        if(j % 10 == 0){
        System.out.println();
        }
        }*/
        //方法二
        int bytes = 0;
        int j = 1;
        while((bytes = in.read(buf, 0, buf.length)) != -1){
            System.out.println("bytes:" + bytes);
            for(int i = 0; i < bytes; i++){
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");//byte类型8位，int类型32位，
                // 为了避免数据转换错误，通过&0xff将高24为清零
                if(j %10 ==0){
                    System.out.println();
                }
            }
        }
        System.out.println("bytes:" + bytes);
        in.close();
    }
    /**
      * 实现批量文件数据的拷贝
      * @param srcFile
      * @param destFile
      * @throws IOException
      */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:" + srcFile + "文件不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException("文件：" + srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while((b = in.read(buf, 0 ,buf.length)) != -1){
            out.write(buf, 0, b);
            out.flush();//清空缓存数据，最好加上这个
        }
        in.close();
        out.close();
    }
}

