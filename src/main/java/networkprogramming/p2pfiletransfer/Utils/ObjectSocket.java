package networkprogramming.p2pfiletransfer.Utils;

import java.io.*;
import java.net.*;

public class ObjectSocket {
    private Socket socket;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    public ObjectSocket(Socket socket) throws IOException {
        this.socket = socket;
        var output = socket.getOutputStream();
        this.writer = new ObjectOutputStream(output);
        var input = socket.getInputStream();
        this.reader = new ObjectInputStream(input);
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectInputStream getReader() {
        return reader;
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }
}
