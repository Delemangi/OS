package lab2.task5;

public class Example {
    public static void main(String[] args) {
        ThreadClass thread = new ThreadClass();
        thread.start();
        System.out.println(thread.getCount());
    }
}

class ThreadClass extends Thread {
    static int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++)
            increment();
    }
}
