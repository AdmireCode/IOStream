
package com.example;
        
        import java.io.FileInputStream;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        
        /**
  * Created by Administrator on 2016/9/23 0023.
  */
        public class FrAndFwDemo {
        public static void main(String[] arg)throws IOException{
        
                        FileReader fr = new FileReader("e:\\test1.txt");//默认编码为gbk
                FileWriter fw = new FileWriter("e:\\test1_out1.txt");
                //FileWriter fw = new FileWriter("e:\\test1_out1.txt", true);往文件后面追加文字
                        char[] buffer = new char[8 * 1024];
                int c;
                while ((c = fr.read(buffer, 0, buffer.length)) != -1){
                        String str = new String(buffer, 0, c);
                        System.out.print(str);
                        fw.write(buffer, 0, c);
                        fw.flush();
                    }
                fr.close();
                fw.close();
            }
    }

