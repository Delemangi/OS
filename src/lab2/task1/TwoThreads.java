package lab2.task1;

import java.util.*;

public class TwoThreads {
    public static void main(String[] args) {
        ThreadClassNumbersLetters<Integer> tcnl1 = new ThreadClassNumbersLetters<>(List.of(1, 2, 3, 4, 5));
        ThreadClassNumbersLetters<String> tcnl2 = new ThreadClassNumbersLetters<>(List.of("A", "B", "C", "D", "E"));

        tcnl1.start();
        tcnl2.start();
    }
}

class ThreadClassNumbersLetters<T> {
    private final List<T> list;

    public ThreadClassNumbersLetters(List<T> list) {
        this.list = list;
    }

    public void start() {
        Thread thread = new Thread(() -> list.forEach(System.out::println));
        thread.start();
        // thread.join();
    }
}
