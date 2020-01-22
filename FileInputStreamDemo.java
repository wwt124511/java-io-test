package com.wwt.字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wwt
 * @ClassName FileInputStreamDemo.java
 * @Description FileInputStream FileOutputStream  类使用例子
 * @createTime 2020-01-21 17:31
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        //FileInputStream  单字节读取文件内容并打印输出
        //testFileInputStream001();

        //System.out.println("===============");
        //FileInputStream  buff方式读取文件内容并打印输出
        //testFileInputStream002();

        //FileOutputStream 输出流 字符串写入输出文件
        //testFileInputStream003();

        //FileOutputStream 输出流 读取一个文件的内容并将其写入另一个文件中
        testFileInputStream004();
    }

    private static void testFileInputStream004() {

        try {
            FileOutputStream out = new FileOutputStream("/Users/wwt/yzf/demo2.txt");

            File file = new File("/Users/wwt/yzf/demo.txt");
            FileInputStream in = new FileInputStream(file);

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1){
                out.write(new String(buf, 0, len).getBytes());
            }

            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testFileInputStream003() {

        try {
            FileOutputStream out = new FileOutputStream("/Users/wwt/yzf/demo2.txt");
            out.write("你好".getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void testFileInputStream001() {
        File file = new File("/Users/wwt/yzf/demo.txt");
        if(!file.exists()){
            throw new RuntimeException("");
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            int i = fis.read();
            while(i!=-1){
                System.out.print((char)i);
                i = fis.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void testFileInputStream002() {

        File file = new File("/Users/wwt/yzf/demo.txt");
        if(!file.exists()){
            throw new RuntimeException("文件不存在");
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            int length = 0;
            byte[] buff = new byte[1024];
            if((length = fis.read(buff)) != -1){
                System.out.println(new String(buff, 0, length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
