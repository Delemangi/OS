package lab2.task3;

import java.util.*;
import java.util.concurrent.*;

public class BlockingQueue<T> {
    private Semaphore sem;
    private Queue<T> queue;

    public BlockingQueue() {
        this.queue = new LinkedList<>();
        this.sem = new Semaphore(1);
    }

    public void enqueue(T item) throws InterruptedException {
        sem.acquire();
        queue.add(item);
        sem.release();
    }

    public T dequeue() throws InterruptedException {
        sem.acquire();
        T item = queue.remove();
        sem.release();

        return item;
    }
}
