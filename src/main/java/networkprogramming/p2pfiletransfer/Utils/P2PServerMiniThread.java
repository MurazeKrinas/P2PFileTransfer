package networkprogramming.p2pfiletransfer.Utils;

import networkprogramming.p2pfiletransfer.FileRequestNoti;

import java.io.IOException;
import java.net.*;

public class P2PServerMiniThread extends Thread implements P2PFileThread {
    private final Socket socket;

    public P2PServerMiniThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void info(ObjectSocket objSocket, Packet packet) {
        java.awt.EventQueue.invokeLater(() -> new FileRequestNoti(objSocket, packet).setVisible(true));
    }

    @Override
    public void run() {
        try {
            listen("serverMini", new ObjectSocket(socket));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
