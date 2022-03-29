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
    static Semaphore game = new Semaphore(0);

    static Lock dressedPlayersLock = new ReentrantLock();
    static Lock donePlayersLock = new ReentrantLock();

    static int dressedPlayers = 0;
    static int donePlayers = 0;

    public void execute() throws InterruptedException {
        // at most 20 players should print this in parallel
        playing.acquire(1);
        System.out.println("Player inside.");

        // at most 10 players may enter the dressing room in parallel
        dressing.acquire(1);
        System.out.println("In dressing room.");
        Thread.sleep(10); // this represents the dressing time
        dressing.release(1);

        dressedPlayersLock.lock();
        dressedPlayers++;
        dressedPlayersLock.unlock();

        dressedPlayersLock.lock();
        if (dressedPlayers == 20) {
            game.release(20);
        }
        dressedPlayersLock.unlock();

        game.acquire(1);

        // after all players are ready, they should start with the game together
        System.out.println("Game started.");
        Thread.sleep(100); // this represents the game duration
        System.out.println("Player done.");

        donePlayersLock.lock();
        donePlayers++;
        donePlayersLock.unlock();

        // only one player should print the next line, representing that the game has finished
        donePlayersLock.lock();
        if (donePlayers == 20) {
            System.out.println("Game finished.");

            playing.release(20);

            donePlayers = 0;
            dressedPlayers = 0;
        }
        donePlayersLock.unlock();
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