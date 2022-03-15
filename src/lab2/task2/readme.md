Со помош на синхронизациските методи да се реши проблемот за определување на бројот на појавувања на буквата А во
стрингот и негово запишување во глобална променлива count.

Секвенцијалното решение не е прифатливо поради тоа што трае многу долго време (поради големината на стрингот). За таа
цел, потребно е да се паралелизира овој процес, при што треба да се напише метода која ќе ги брои појавувањата на
буквата А во помал фрагмент од стрингот, при што резултатот повторно се чува во глобалната заедничка променлива count.

Напомена: Почетниот код е даден во почетниот код CountLetter. Задачата да се тестира над стринг од минимум 1000
карактери.

-----

Solve the issue of detecting the number of occurrences of the letter A in a large array by using thread synchronization
methods. The counts are written / incremented in the global variable count on each find.

The standard sequential solution is not acceptable as it takes a long time (because the string is very large).
Therefore, you need to implement this process and write a method which will count the occurrences of letter A in smaller
fragments of the string, while the result is still kept in the global count variable.

Note: The starting code for the solutions is given in CountLetter. You need to test it with an array of at least 1.000
elements.

------------

```
public class CountLetter {

    /**
     * Promenlivata koja treba da go sodrzi brojot na pojavuvanja na bukvata A
     */
    int count = 0;
    /**
     * TODO: definirajte gi potrebnite elementi za sinhronizacija
     */

    public void init() {
    }

    class Counter extends Thread {

        public void count(String data) throws InterruptedException {
            // da se implementira
        }
        private String data;

        public Counter(String data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                count(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CountLetter environment = new CountLetter();
            environment.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() throws Exception {

        init();

        HashSet<Thread> threads = new HashSet<Thread>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String pom = bf.readLine();
        String [] data = pom.split("");
        
        for(int i = 0; i< data.length; i++) {
            
            Counter c = new Counter(data[i]);
            threads.add(c);
        }


        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        System.out.println(count);


    }
}
```
