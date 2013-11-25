package com.babyduncan.nio2;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 16:59
 * to be continued ..  nio.2 is only supported in jdk 1.7 .
 */
public class EchoServer {
//    public static void main(String... args) {
//        System.out.println("Listening for connections on port " + port);
//        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
//        InetSocketAddress address = new InetSocketAddress(port);
//        serverChannel.bind(address);
//        final CountDownLatch latch = new CountDownLatch(1);
//        serverChannel.accept(null, new
//                CompletionHandler<AsynchronousSocketChannel, Object>() {
//                    @Override
//                    public void completed(final AsynchronousSocketChannel channel, Object attachment) {
//                        serverChannel.accept(null, this);
//                        ByteBuffer buffer = ByteBuffer.allocate(100);
//                        channel.read(buffer, buffer,
//                                new EchoCompletionHandler(channel));
//                    }
//
//                    @Override
//                    public void failed(Throwable throwable, Object attachment) {
//                        try {
//                            serverChannel.close();
//                        } catch (IOException e) {
//                            // ingnore on close
//                        } finally {
//                            latch.countDown();
//                        }
//                    }
//                });
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }

//    private final class EchoCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
//        private final AsynchronousSocketChannel channel;
//
//        EchoCompletionHandler(AsynchronousSocketChannel channel) {
//            this.channel = channel;
//        }
//
//        @Override
//        public void completed(Integer result, ByteBuffer buffer) {
//            buffer.flip();
//            channel.write(buffer, buffer, new CompletionHandler<Integer,
//                    ByteBuffer>() {
//
//                @Override
//                public void completed(Integer result, ByteBuffer buffer) {
//                    if (buffer.hasRemaining()) {
//                        channel.write(buffer, buffer, this);
//                    } else {
//                        buffer.compact();
//                        channel.read(buffer, buffer, EchoCompletionHandler.this);
//                    }
//                }
//
//                EchoCompletionHandler.this);
//
//                @Override
//                public void failed(Throwable exc, ByteBuffer attachment) {
//                    try {
//                        channel.close();
//                    } catch (IOException e) {
//                        // ingnore on close
//                    }
//                }
//            });
//        }
//
//        @Override
//        public void failed(Throwable exc, ByteBuffer attachment) {
//            try {
//                channel.close();
//            } catch (IOException e) {
//                // ingnore on close
//            }
//        }
//    }

}
