package org.apache.rocketmq.example.bytebuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Main {


    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = file.getChannel();

        /**
         * 第一个参数表示使用的是读写模式，
         * 第二个参数，表示可以直接修改的起始位置
         * 第三个参数，表示映射到内存的大小，即可以将文件的多少个字节映射到内存，即可以直接修改的范围
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'H');

        file.close();
    }

}
