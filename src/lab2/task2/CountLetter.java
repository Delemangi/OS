package lab2.task2;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class CountLetter {
    private int count = 0;
    private Semaphore semaphore;

    public void init() {
        semaphore = new Semaphore(1);
    }

    class Counter extends Thread {
        public void count(String data) throws InterruptedException {
            if (data.equals("A")) {
                semaphore.acquire();
                count++;
                semaphore.release();
            }
        }

        private String data;

        public Counter(String data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                count(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CountLetter environment = new CountLetter();
            environment.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() throws Exception {
        init();

        HashSet<Thread> threads = new HashSet<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String pom = bf.readLine();
        String[] data = pom.split("");

        for (int i = 0; i < data.length; i++) {
            Counter c = new Counter(data[i]);
            threads.add(c);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(count);
    }
}