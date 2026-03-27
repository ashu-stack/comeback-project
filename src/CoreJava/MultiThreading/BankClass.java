package CoreJava.MultiThreading;

public class BankClass {
    int balance = 100;

    public BankClass(){

    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public void withdrawMoney(int amount){
        if(this.balance >= amount){
            this.balance -= amount;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }

    public int checkBalance(){
        return this.balance;
    }
}
