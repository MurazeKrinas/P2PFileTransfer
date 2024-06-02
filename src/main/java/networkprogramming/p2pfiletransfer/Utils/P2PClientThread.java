package networkprogramming.p2pfiletransfer.Utils;

import java.io.*;
import java.net.*;

public class P2PClientThread extends Thread implements P2PFileThread {
    private final String host;
    private final int port;
    private Packet packet;
    private boolean sentPacket= false;

    public P2PClientThread(String host, int port, Packet packet) {
        this.host = host;
        this.port = port;
        this.packet = packet;
    }

    @Override
    public void accept() {
        System.out.println("[client] server accepted file transfer");
    }

    @Override
    public void deny() {
        System.out.println("[client] server denied file transer");
        interrupt();
    }

    @Override
    public void run() {
        try {
            System.out.println("[client] start connecting");
            var serverSocket = new Socket(host, port);
            var objServerSocket = new ObjectSocket(serverSocket);
            System.out.println("[client] conect to server successfully!");

            while (!isInterrupted()) {
                if (!sentPacket) {
                    objServerSocket.getWriter().writeObject(packet);
                    sentPacket = true;
                }

                listen("client", objServerSocket);
            }

            System.out.println("[client] stop connecting to server");
            if (serverSocket != null) {
                objServerSocket.getWriter().close();
                objServerSocket.getReader().close();
                serverSocket.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
