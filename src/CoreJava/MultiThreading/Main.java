package CoreJava.MultiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "count: " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + "incremented");
                }
            }
        };

        Thread writerThread = new Thread(writeTask, "Writer thread");
        Thread readerThread = new Thread(readTask, "ReadThread");
        Thread readerThread1 = new Thread(readTask, "ReadThread");
        Thread readerThread2 = new Thread(readTask, "ReadThread");
        writerThread.start();
        readerThread.start();
        readerThread1.start();
        readerThread2.start();

        try{
            writerThread.join();
            readerThread.join();
            readerThread1.join();
            readerThread2.join();

            System.out.println(counter.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
