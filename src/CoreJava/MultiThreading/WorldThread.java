package CoreJava.MultiThreading;

public class WorldThread extends Thread{
    @Override
    public void run(){
        int count = 10;
        while(count > 0 ){
            System.out.println(Thread.currentThread().getName() + "Count: " + count);
            Thread.yield();
            count--;
        }

    }
}
