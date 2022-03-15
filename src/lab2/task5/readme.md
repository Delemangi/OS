Која ќе биде вредноста на променливата count која ќе се испечати во дадениот код?

------------

In the following code, what value of count variable is going to be printed?

```
public class Example{
public static void main() {

            ThreadClass thread = new ThreadClass();
            thread.start();
            System.out.println(thread.getCount());
    }
}

class ThreadClass extends Thread{
static int count = 0;
public void increment() {
count++;
}
public int getCount(){
return count;
}

    @Override
    public void run() {
        for(int i = 0; i < 50; i++)
            increment();
    }
}
```