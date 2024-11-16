package main.java;

import java.io.*;
import java.net.Socket;

public class Client {
    public static final int PORT = 8080;
    private static Socket clientSocket;
    private static BufferedReader reader;

    private static BufferedReader in;
    private static BufferedWriter out;
    Client.ReadMsg rMsg = new ReadMsg();
    Client.WriteMsg wMsg = new WriteMsg();

    public Client() throws IOException {
        clientSocket = new Socket("localhost", PORT);
        reader = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        rMsg.start();
        wMsg.start();
    }

    public static void main(String[] args) throws IOException {
        try {
            Client client = new Client();

            client.rMsg.join();
            client.wMsg.join();

            // closeConnection();

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void closeConnection() {
        try {
            in.close();
            out.close();
            reader.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("stop")) {
                        // out.write("stop" + '\n');
                        // out.flush();
                        // closeConnection();
                        break;
                    }
                    System.out.println("\rUser2: " + str);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class WriteMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {

                    userWord = reader.readLine();

                    if (userWord.equals("stop")) {
                        out.write("stop" + '\n');
                        out.flush();
                        closeConnection();
                        break;
                    }

                    out.write(userWord + "\n");

                    out.flush();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
