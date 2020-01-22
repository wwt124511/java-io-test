package com.wwt.字节流;

import java.io.*;

/**
 * @author wwt
 * @ClassName BufferedInputStreamDemo.java
 * @Description TODO
 * @createTime 2020-01-22 14:06
 */
public class BufferedInputStreamDemo {


    public static void main(String[] args) {

        //BufferedInputStream 输入流读取文件内容并打印
        inputTest01();

        //BufferedInputStream 输入流读取文件内容并写入另一个文件中
        outputTest01();
    }

    private static void outputTest01() {

        BufferedInputStream bi = null;
        FileOutputStream out = null;
        try {
            bi = new BufferedInputStream(new FileInputStream("/Users/wwt/yzf/demo.txt"));
            out = new FileOutputStream("/Users/wwt/yzf/demo2.txt");

            int len = 0;
            byte[] buff = new byte[1024];
            if((len = bi.read(buff)) != -1){
                out.write(new String(buff, 0, len).getBytes());
            }
            bi.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inputTest01() {

        BufferedInputStream bi = null;
        try {
            bi = new BufferedInputStream(new FileInputStream("/Users/wwt/yzf/demo.txt"));

            int len = 0;
            byte[] buff = new byte[1024];
            if((len = bi.read(buff)) != -1){
                System.out.println(new String(buff, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != bi){
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
