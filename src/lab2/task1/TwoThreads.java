package lab2.task1;

import java.util.*;

public class TwoThreads {
    public static void main(String[] args) throws InterruptedException {
        ThreadClassNumbersLetters<Integer> tcnl1 = new ThreadClassNumbersLetters<>(List.of(1, 2, 3, 4, 5));
        ThreadClassNumbersLetters<String> tcnl2 = new ThreadClassNumbersLetters<>(List.of("A", "B", "C", "D", "E"));

        tcnl1.start();
        tcnl1.join();
        tcnl2.start();
        tcnl2.join();
    }
}

class ThreadClassNumbersLetters<T> {
    private final List<T> list;
    private final Thread thread;

    public ThreadClassNumbersLetters(List<T> list) {
        this.list = list;
        this.thread = new Thread(this::print);
    }

    public void print() {
        list.forEach(System.out::println);
    }

    public void start() {
        thread.start();
    }

    public void join() throws InterruptedException {
        thread.join();
    }
}