package com.dianping.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by fang on 2018/5/8.
 */
public class NioClient {
    private SocketChannel socketChannel;
    private ByteBuffer buffer;

    private void open(String host, int port) throws IOException {
        this.socketChannel = SocketChannel.open();
        socketChannel.socket().connect(new InetSocketAddress(host, port));
        buffer = ByteBuffer.allocate(1024);
    }

    private void write(String data) throws IOException {
        buffer.clear();
        buffer.put(data.getBytes());
        buffer.flip();
        System.out.println("sender: "+ data);
        socketChannel.write(buffer);
    }

    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.open("127.0.0.1", 1234);
        int i = 0;
        while (true) {
            client.write("req" + i++);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
}
