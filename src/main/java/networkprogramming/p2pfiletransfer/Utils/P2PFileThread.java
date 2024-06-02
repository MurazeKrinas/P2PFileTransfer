package networkprogramming.p2pfiletransfer.Utils;

import java.io.*;

/**
 *
 * @author vanlinh
 */
public interface P2PFileThread {
    default void info(ObjectSocket objSocket, Packet packet) {
    };

    default void accept() {
    };

    default void deny() {
    };

    default void listen(String tag, ObjectSocket objSocket) {
        try {
            while (true) {
                Packet packet;

                try {
                    packet = (Packet) objSocket.getReader().readObject();
                } catch (Exception ex) {
                    continue;
                }

                if (packet.getType() == 0)
                    info(objSocket, packet);
                else if (packet.getType() == 1)
                    accept();
                else if (packet.getType() == 2) {
                    deny();
                    break;
                }
            }
            objSocket.getSocket().close();
        } catch (IOException ex) {
            System.out.println(String.format("[%s] %s", tag, "socket io stream error"));
        }
    }
}
