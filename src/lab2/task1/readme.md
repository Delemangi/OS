Извршете го примерот од TwoThreads. Потоа, модифицирајте ја програмата така што ќе користите само една класа за нитки,
ThreadClassNumbersLetters. Во конструкторот на класата ќе се предаде листа која соодветната инстанца треба да ја
отпечати. Нитката не треба да ја наследува класата Thread. Однесувањето на новата програма треба да биде исто како на
оригиналната, односно повторно треба да имате две нитки кои ќе го извршуваат посебно методот run(): едната нитка ќе ги
печати првите пет броеви, потоа другата ќе ги печати првите пет букви од англиската азбука,

-------

Execute the TwoThreads example. Then modify the program so that it uses only one thread class,
ThreadClassNumbersLetters. In the constructor of the class you should pass the list which should be printed by the
corresponding instance. The thread should not inherit from the Thread class. The new program should behave the same way
as the original one, i.e. you must have two threads again which will separately execute the run() method: one thread
will print the first five numbers, than the other one will print the first five letters from the english alphabetic

--------

```
public class TwoThreads {
    public static void main(String[] args) throws InterruptedException {
        ThreadClassLetters letters = new ThreadClassLetters();
        ThreadClassNumbers numbers = new ThreadClassNumbers();
        numbers.start();
        numbers.join();
        letters.start();
        letters.join();
    }
}


class ThreadClassNumbers extends Thread {
    @Override
    public void run() {
        for(int i = 0; i<5;i++) System.out.println(i);
    }
}

class ThreadClassLetters extends Thread {
    @Override
    public void run() {
        for(int i = 0; i<5;i++) System.out.println((char)(i + 65));
    }
}

class ThreadClassNumbers extends Thread {
    @Override
    public void run() {
        for(int i = 0; i<10;i++) System.out.println(i);
    }
}

class ThreadClassLetters extends Thread {
    @Override
    public void run() {
        for(int i = 0; i<10;i++) System.out.println((char)(i + 65));
    }
}
```
