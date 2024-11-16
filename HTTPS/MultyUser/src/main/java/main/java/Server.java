package main.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 8080;
    public static LinkedList<ServerSomething> serverList = new LinkedList<>();
    public static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(PORT);
        try {
            while (true) {
                var socket = server.accept();
                try {
                    serverList.add(new ServerSomething(socket));
                } catch (IOException e) {
                    socket.close();
                    System.out.println(e.getMessage());
                    break;
                }
            }
        } finally {
            server.close();
            System.out.println("Server closed!");
        }
    }
}
