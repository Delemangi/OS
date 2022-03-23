package lab3.task3;

import java.util.*;
import java.util.concurrent.*;

public class Demo {
    public static void main(String args[]) throws InterruptedException {
        DiningPhilosophers.runTest();
    }
}

class DiningPhilosophers {
    private static Random random = new Random(System.currentTimeMillis());
    private Semaphore[] forks = new Semaphore[6];

    public DiningPhilosophers() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
        forks[5] = new Semaphore(1);
    }

    public void lifecycleOfPhilosopher(int id) throws InterruptedException {
        while (true) {
            think();
            eat(id);
        }
    }

    void think() throws InterruptedException {
        Thread.sleep(random.nextInt(50));
    }

    void eat(int id) throws InterruptedException {
        int fork = (id + 1) % forks.length;

        forks[id].acquire(1);
        forks[fork].acquire(1);

        Thread.sleep(random.nextInt(50));

        forks[id].release(1);
        forks[fork].release(1);
    }

    static void runPhilosopher(DiningPhilosophers dp, int id) {
        try {
            dp.lifecycleOfPhilosopher(id);
        } catch (InterruptedException ie) {

        }
    }

    public static void runTest() throws InterruptedException {
        final DiningPhilosophers dp = new DiningPhilosophers();

        Thread p1 = new Thread(() -> runPhilosopher(dp, 0));
        Thread p2 = new Thread(() -> runPhilosopher(dp, 1));
        Thread p3 = new Thread(() -> runPhilosopher(dp, 2));
        Thread p4 = new Thread(() -> runPhilosopher(dp, 3));
        Thread p5 = new Thread(() -> runPhilosopher(dp, 4));
        Thread p6 = new Thread(() -> runPhilosopher(dp, 5));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
        p6.join();
    }
}