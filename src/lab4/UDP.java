package lab4;

import java.io.*;
import java.net.*;

public class UDP {
    public static final String ADDRESS = "194.149.135.49";
    public static final int PORT = 9753;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(ADDRESS);
            String index = "206055";
            DatagramPacket dp = new DatagramPacket(index.getBytes(), index.length(), address, PORT);

            socket.send(dp);
            System.out.println("Sent: " + new String(dp.getData()));

            dp = new DatagramPacket(new byte[1024], 1024);

            socket.receive(dp);
            System.out.println("Received: " + new String(dp.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
