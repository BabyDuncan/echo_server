package com.babyduncan.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 15:41
 * echo server with io
 */
public class EchoServer {

    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);
        while (true) {
            final Socket clientSocket = serverSocket.accept();     // block until one client connect
            // a telnet for example : telnet localhost 1024   use control+] to exit telnet
            System.out.println("get one connection " + clientSocket);
            // one thread one connection
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                        while (true) {
                            printWriter.write(bufferedReader.readLine());
                            printWriter.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
