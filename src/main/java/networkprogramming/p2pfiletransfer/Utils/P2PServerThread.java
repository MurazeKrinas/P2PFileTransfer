package networkprogramming.p2pfiletransfer.Utils;

import java.io.*;
import java.net.*;

public class P2PServerThread extends Thread {
    private final int port;
    private final ServerSocket serverSocket;

    public P2PServerThread(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run() {
        try {
            System.out.println("[server] start listening");
            while (true) {
                var clientSocket = serverSocket.accept();
                new P2PServerMiniThread(clientSocket).start();
            }
        } catch (Exception ex) {
            System.out.println("[server] stop listening");
        }
    }

    @Override
    public void interrupt() {
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
