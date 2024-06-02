package networkprogramming.p2pfiletransfer.Utils;

import java.io.Serializable;

public class Packet implements Serializable {
    /*
     * Type = 0: Request packet
     * Type = 1: Accept response
     * Type = 2: Deny response
     */
    private int type;
    private byte[] data;
    private String message, fileName;

    private String machineName, fromIP, toIP;
    private int fromPort, toPort;

    public Packet(int type, byte[] data, String name, String fromIP, String toIP, int fromPort, int toPort, String fileName,
            String message) {
        this.type = type;
        this.data = data;
        this.machineName = name;
        this.fileName = fileName;
        this.message = message;
        this.fromIP = fromIP;
        this.toIP = toIP;
        this.fromPort = fromPort;
        this.toPort = toPort;
    }

    public Packet(int type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public int getType() {
        return type;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getFromIP() {
        return fromIP;
    }

    public String getToIP() {
        return toIP;
    }

    public int getFromPort() {
        return fromPort;
    }

    public int getToPort() {
        return toPort;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMessage() {
        return message;
    }
}
