package lab4;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class TCP {
    public static final String ADDRESS = "194.149.135.49";
    public static final int PORT = 9753;
    public static ClientReceive cr;
    public static ClientSend cs;

    public static void main(String[] args) {
        try (Socket socket = new Socket(ADDRESS, PORT)) {
            cr = new ClientReceive(socket);
            cs = new ClientSend(socket);

            cr.start();
            cs.start();

            cs.addMessage("login:206055");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();

                if (message.equals("exit")) {
                    System.exit(0);
                }

                cs.addMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientReceive extends Thread {
    private final Socket socket;

    public ClientReceive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;

            while (true) {
                line = in.readLine();

                if (line == null) {
                    continue;
                }

                if (line.contains("Succesfully logged on to server")) {
                    TCP.cs.addMessage("hello:206055");
                }

                System.out.println("Received: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientSend extends Thread {
    private final Socket socket;
    private final Queue<String> queue;
    private final Lock lock;

    public ClientSend(Socket socket) {
        this.socket = socket;
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                lock.lock();
                String line = queue.poll();
                lock.unlock();

                if (line == null) {
                    continue;
                }

                out.println(line);

                System.out.println("Sent: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMessage(String message) {
        lock.lock();
        queue.add(message);
        lock.unlock();
    }
}