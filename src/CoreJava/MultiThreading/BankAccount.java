package CoreJava.MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance=100;
    public final Lock lock = new ReentrantLock();
    public BankAccount() {

    }

    public void withdrawAmount(int amount) throws InterruptedException {
        if(lock.tryLock(1000, TimeUnit.MICROSECONDS)) {
            if (amount <= balance) {
                try{
                    System.out.println(Thread.currentThread().getName() + " Withdrawal process.....");
                    Thread.sleep(10000);
                    balance -= amount;
                    System.out.println("Balance remaining: " + balance);
                }catch(Exception e){

                }finally {
                    lock.unlock();
                }

            } else {
                System.out.println(Thread.currentThread().getName() + "Insufficient balance....");
            }
        }else{
            System.out.println("No lock ");
        }
    }


}
