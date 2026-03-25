package CoreJava.MultiThreading;

public class MyThread extends Thread{
    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++){
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        MyThread t1 = new MyThread(counter1);
        MyThread t2 = new MyThread(counter1);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

        } catch (InterruptedException e) {

        }
        System.out.println(counter1.getCount());

    }
}
