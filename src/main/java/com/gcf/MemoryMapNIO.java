package com.gcf;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MemoryMapNIO {
    public static void main(String[] args) throws IOException {
        //1.依然是获取channel对象
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\13159\\Desktop\\新建文本文档.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\13159\\Desktop\\11111.txt"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //第一种内存映射拷贝形式，使用特殊的byteBUffer作为数据载体，内存映射文件
//        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
//        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
//
//        //读写，方法有变化
//        byte[] bytes = new byte[inMappedBuffer.limit()];
//        inMappedBuffer.get(bytes);
//        outMappedBuffer.put(bytes);

        //第二种内存拷贝形式。
        inChannel.transferTo(0,inChannel.size(),outChannel);
    }
}
