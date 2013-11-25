package com.babyduncan.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 15:55
 * an echo server with NIO(non-blocking io not new io , because it is not new any more .)
 */
public class EchoServer {

    public static void main(String... args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(33555);
        serverSocket.bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set readKeys = selector.selectedKeys();
            Iterator iterator = readKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();
                try {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel__ = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel client = serverSocketChannel__.accept();
                        System.out.println("get one connection .." + client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(1000));
                    }
                    if (selectionKey.isReadable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                        client.read(byteBuffer);
                    }
                    if (selectionKey.isWritable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                        byteBuffer.flip();
                        client.write(byteBuffer);
                        byteBuffer.compact();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    selectionKey.cancel();
                    selectionKey.channel().close();
                }

            }
        }
    }

}
