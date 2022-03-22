package lab2.task3;

import java.util.concurrent.locks.*;

public class BlockingQueue<T> {
    T[] contents;
    int capacity;
    Lock lock;
    int count;
    int head;
    int tail;

    public BlockingQueue(int capacity) {
        contents = (T[]) new Object[capacity];
        this.capacity = capacity;
        lock = new ReentrantLock();
        count = head = tail = 0;
    }

    public void enqueue(T item) {
        lock.lock();

        contents[tail] = item;
        if (++tail == contents.length) {
            tail = 0;
        }
        ++count;

        lock.unlock();
    }

    public T dequeue() {
        lock.lock();

        T item = contents[head];
        if (++head == contents.length) {
            head = 0;
        }
        --count;

        lock.unlock();

        return item;
    }
}