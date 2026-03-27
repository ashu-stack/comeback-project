package CoreJava.MultiThreading;

// Start, run, sleep, join,set priority,interrupt, yield, setdaemon, synchronized


//Daemon threads : background threads, jvm wont wait
public class HelloWorld {
    public static void main(String[] args) {
        WorldThread thread = new WorldThread();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        t1.setName("First");
        t2.setName("Second");
        t3.setName("Third");
        //t3.setPriority(Thread.MAX_PRIORITY);
        //t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

    }
}
