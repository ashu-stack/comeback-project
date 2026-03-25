package CoreJava.MultiThreading;

public class HelloWorld {
    public static void main(String[] args) {
        WorldThread thread = new WorldThread();
        Thread t1 = new Thread(thread);
        t1.start();
        while(true){
            System.out.println("Hello ");
        }


    }
}
