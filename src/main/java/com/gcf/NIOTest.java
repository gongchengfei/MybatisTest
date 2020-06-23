package com.gcf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) throws IOException {
        //获取channel
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileInputChannel = null;
        FileChannel fileOutputChannel = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\13159\\Desktop\\新建文本文档.txt");
            fileOutputStream = new FileOutputStream("C:\\Users\\13159\\Desktop\\11.txt");

            fileInputChannel = fileInputStream.getChannel();
            fileOutputChannel = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
            //读数据
            while (fileInputChannel.read(byteBuffer) != -1){
                byteBuffer.flip();//由写模式反转为读模式
                fileOutputChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            System.out.println("finished!!");
        }catch (Exception e){

        }finally {
            fileInputStream.close();
            fileOutputStream.close();
            fileInputChannel.close();
            fileOutputChannel.close();
        }

    }
}
