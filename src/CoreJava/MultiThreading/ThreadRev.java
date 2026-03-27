package CoreJava.MultiThreading;

public class ThreadRev extends Thread{

    private Count count;
    public ThreadRev(String name){
        super(name);
    }

    public ThreadRev(String name, Count count){
        super(name);
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count.increment();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " count incremented. ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
       BankClass bankClass = new BankClass();
        Runnable withdrawThread = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    bankClass.withdrawMoney(40);
                }
                System.out.println(Thread.currentThread().getName() + " Money withdrawn..........");
            }
        };

        Runnable depositThread = new Runnable() {
            @Override
            public void run() {
                bankClass.deposit(5);
                System.out.println(Thread.currentThread().getName() + "Money deposited....");
            }
        };

        Thread t1 = new Thread(withdrawThread,"Withdraw");
        Thread t2 = new Thread(depositThread, "Deposit");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println(bankClass.checkBalance());
        }

    }
}
