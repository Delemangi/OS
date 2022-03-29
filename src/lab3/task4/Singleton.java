package lab3.task4;

import java.util.*;
import java.util.concurrent.locks.*;

public class Singleton {
    private static volatile Singleton singleton;
    private static Lock lock = new ReentrantLock();

    private Singleton() {
    }

    public static Singleton getInstance() {
        lock.lock();
        if (singleton == null) {
            singleton = new Singleton();
        }
        lock.unlock();

        return singleton;
    }

    public static void main(String[] args) throws InterruptedException {
        List<SingletonThread> threads = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            threads.add(new SingletonThread());
        }

        for (SingletonThread thread : threads) {
            thread.start();
        }

        for (SingletonThread thread : threads) {
            thread.join();
        }

        for (SingletonThread thread : threads) {
            System.out.println(thread.singleton);
        }
    }
}

class SingletonThread extends Thread {
    public Singleton singleton;

    @Override
    public void run() {
        singleton = Singleton.getInstance();
    }
}