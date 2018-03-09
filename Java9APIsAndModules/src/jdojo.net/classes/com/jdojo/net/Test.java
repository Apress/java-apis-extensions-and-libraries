// Test.java
package com.jdojo.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketOption;
import java.net.UnknownHostException;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws UnknownHostException, IOException {
        ServerSocket serverSocket = new ServerSocket(12900, 100, InetAddress.getByName("localhost"));

        Set<SocketOption<?>> options = serverSocket.supportedOptions​();
        System.out.println(options);

    }
}
