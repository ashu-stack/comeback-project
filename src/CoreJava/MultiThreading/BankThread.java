package CoreJava.MultiThreading;

public class BankThread extends Thread{

    BankAccount bankAccount;

    public BankThread(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
       // System.out.println(Thread.currentThread().getName());
        try {
            bankAccount.withdrawAmount(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        BankThread thread1 = new BankThread(account);
        BankThread thread2 = new BankThread(account);

        thread1.run();
        thread2.run();
    }
}
