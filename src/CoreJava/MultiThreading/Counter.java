package CoreJava.MultiThreading;

public class Counter {
    public int count=0;

    public Counter() {

    }

    public synchronized void increment(){
        this.count++;
    }

    public int getCount(){
        return this.count;
    }
}
