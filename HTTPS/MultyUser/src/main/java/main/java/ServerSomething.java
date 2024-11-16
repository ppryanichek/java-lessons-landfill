package main.java;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ServerSomething extends Thread {
    private Socket socket;

    private LinkedList<String> buffer;

    private BufferedReader in;
    private BufferedWriter out;

    public ServerSomething(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start();

    }

    @Override
    public void run() {
        String word = "";
        try {
            while (true) {
                word = in.readLine();
                if (word.equals("stop")) {
                    break;
                }

                for (ServerSomething v : Server.serverList) {
                    if (v == this) {
                        continue;
                    }
                    v.send(word);
                }
            }

            Server.serverList.remove(this);

            this.send(word);
            Server.server.close();
        } catch (IOException e) {
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + '\n');
            out.flush();
        } catch (IOException ignored) {
        }
    }
}
