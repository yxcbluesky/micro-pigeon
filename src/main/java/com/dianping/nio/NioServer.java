package com.dianping.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by fang on 2018/5/8.
 */
public class NioServer {

    ByteBuffer buffer;

    public NioServer() {
        buffer = ByteBuffer.allocate(1024);
    }

    private void go(String host, Integer port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(host, port));
        Selector selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int n = selector.select();
            if (n == 0) { // 事件未就绪
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) { // 新连接
                    System.out.println("新的连接");
                    serverSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    register(selector, socketChannel, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    readDataFromChannel((SocketChannel) key.channel());
                }
                iterator.remove();
            }
        }
    }

    private void register(Selector selector, SocketChannel channel, int ops) throws IOException {
        if (channel != null) {
            channel.configureBlocking(false);
            channel.register(selector, ops);
        }
    }

    private void readDataFromChannel(SocketChannel channel) throws IOException {
        buffer.clear();
        int count;
        while ((count = channel.read(buffer)) > 0) {
            buffer.flip();
            System.out.print("receiver:");
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            System.out.println();
            buffer.clear();
        }
        if (count < 0) {
            channel.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new NioServer().go("127.0.0.1", 1234);
    }
}
