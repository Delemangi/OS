package lab3.task2;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class BasketballTournament {
    public static void main(String[] args) {
        HashSet<Player> threads = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Player p = new Player();
            threads.add(p);
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threads.stream().filter(Thread::isAlive).forEach(thread -> {
            System.out.println("Possible deadlock!");
            thread.interrupt();
        });

        for (Player player : threads) {
            if (player.isInterrupted()) {
                return;
            }
        }

        System.out.println("Tournament finished.");
    }
}

class Player extends Thread {
    static Semaphore playing = new Semaphore(20);
    static Semaphore dressing = new Semaphore(10);
    static Lock playersLock = new ReentrantLock();
    static Lock counterLock = new ReentrantLock();
    static volatile int players = 0;
    static int counter = 0;

    public void execute() throws InterruptedException {
        // at most 20 players should print this in parallel
        Player.playing.acquire(1);
        System.out.println("Player inside.");

        // at most 10 players may enter the dressing room in parallel
        Player.dressing.acquire(1);
        System.out.println("In dressing room.");
        Thread.sleep(10); // this represents the dressing time
        Player.dressing.release(1);

        playersLock.lock();
        players++;
        playersLock.unlock();
        
        while (players != 20) Thread.onSpinWait();

        // after all players are ready, they should start with the game together
        System.out.println("Game started.");
        Thread.sleep(100); // this represents the game duration
        System.out.println("Player done.");

        counterLock.lock();
        counter++;
        counterLock.unlock();

        // only one player should print the next line, representing that the game has finished
        if (counter == 20) {
            System.out.println("Game finished.");
            Player.playing.release(20);
            counter = 0;
            players = 0;
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