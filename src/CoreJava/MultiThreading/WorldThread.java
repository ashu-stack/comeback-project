package CoreJava.MultiThreading;

public class WorldThread extends Thread{
    @Override
    public void run(){
        int count = 5;
        while(count > 0 ){
            System.out.println(Thread.currentThread().getName() + "Count: " + count);
            count--;
        }

    }
}
