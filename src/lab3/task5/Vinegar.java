package lab3.task5;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Vinegar {
    static Semaphore carbon = new Semaphore(2);
    static Semaphore hydrogen = new Semaphore(4);
    static Semaphore oxygen = new Semaphore(2);
    static Semaphore bonding = new Semaphore(0);
    static Lock lock = new ReentrantLock();

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        HashSet<Thread> threads = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            threads.add(new C());
            threads.add(new H());
            threads.add(new H());
            threads.add(new O());
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2000);
        }

        // for each thread, terminate it if it is not finished

        threads.stream().filter(Thread::isAlive).forEach(thread -> {
            thread.interrupt();
            System.out.println("Possible deadlock!");
        });

        for (Thread thread : threads) {
            if (thread.isInterrupted()) {
                return;
            }
        }

        System.out.println("Process finished.");
    }

    static class C extends Thread {
        public void execute() throws InterruptedException {
            // at most 2 atoms should print this in parallel
            carbon.acquire(1);
            System.out.println("C here.");

            if (carbon.availablePermits() == 0 && hydrogen.availablePermits() == 0 && oxygen.availablePermits() == 0) {
                bonding.release(8);
            }

            // after all atoms are present, they should start with the bonding process together
            bonding.acquire(1);
            System.out.println("Molecule bonding.");
            Thread.sleep(100); // this represents the bonding process

            System.out.println("C done.");

            lock.lock();
            counter++;
            lock.unlock();

            carbon.release(1);

            // only one atom should print the next line, representing that the molecule is created
            if (counter == 8) {
                counter = 0;
                System.out.println("Molecule created.");
            }
        }

        @Override
        public void run() {
            try {
                execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class H extends Thread {
        public void execute() throws InterruptedException {
            // at most 4 atoms should print this in parallel
            hydrogen.acquire(1);
            System.out.println("H here.");

            if (carbon.availablePermits() == 0 && hydrogen.availablePermits() == 0 && oxygen.availablePermits() == 0) {
                bonding.release(8);
            }

            // after all atoms are present, they should start with the bonding process together
            bonding.acquire(1);
            System.out.println("Molecule bonding.");
            Thread.sleep(100);// this represent the bonding process

            System.out.println("H done.");

            lock.lock();
            counter++;
            lock.unlock();

            hydrogen.release(1);

            // only one atom should print the next line, representing that the molecule is created
            if (counter == 8) {
                counter = 0;
                System.out.println("Molecule created.");
            }
        }

        @Override
        public void run() {
            try {
                execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class O extends Thread {
        public void execute() throws InterruptedException {
            // at most 2 atoms should print this in parallel
            oxygen.acquire(1);
            System.out.println("O here.");

            if (carbon.availablePermits() == 0 && hydrogen.availablePermits() == 0 && oxygen.availablePermits() == 0) {
                bonding.release(8);
            }

            // after all atoms are present, they should start with the bonding process together
            bonding.acquire(1);
            System.out.println("Molecule bonding.");
            Thread.sleep(100);// this represent the bonding process

            System.out.println("O done.");

            lock.lock();
            counter++;
            lock.unlock();

            oxygen.release(1);

            // only one atom should print the next line, representing that the molecule is created
            if (counter == 8) {
                counter = 0;
                System.out.println("Molecule created.");
            }
        }

        @Override
        public void run() {
            try {
                execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}