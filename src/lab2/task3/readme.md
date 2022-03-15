Симулирајте сценарио каде повеќе нишки истовремено додаваат и одземаат елементи од една инстанца од типот BlockingQueue.
Синхронизирајте го пристапот до enqueue и dequeue со користење на синхронизациски механизам со помош на Семафори.

----

Simulate a scenario where multiple concurrent threads enqueue and dequeue elements from one instance of the type
BlockingQueue. Synchronize the access to enqueue and dequeue using a synchronization mechanism with the help of
Semaphores.

```
public class BlockingQueue<T> {

    T[] contents;
    int capacity;
 
    public BlockingQueue(int capacity) {
        contents = (T[]) new Object[capacity];
        this.capacity = capacity;
    }
 
    public void enqueue(T item) {
    }
 
    public T dequeue() {
    }
}
```