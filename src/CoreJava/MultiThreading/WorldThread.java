package CoreJava.MultiThreading;

public class WorldThread extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("World");

        }

    }
}
