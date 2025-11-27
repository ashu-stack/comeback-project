package Recursion;

public class RecurionMain {
    public static void main(String[] args) {
        int number = 1254;
       int ans =  sumOfDigits(number);
        System.out.println(ans);
    }

    private static int product(int n){
        if(n%10 == n){
            return n;
        }
        return n%10 * product(n/10);
    }

    private static int printFactorial(int number) {
        if(number == 1){
            return 1;
        }
        return number * printFactorial(number-1);
    }


    private static int printSum(int number) {
        if(number == 1){
            return 1;
        }
        return number + printSum(number-1);
    }


    private static void printSequence(int number) {
        if(number == 0){
            return;
        }
        System.out.println(number);
        printSequence(number-1);


    }

    private static void printName(String name, int number) {
        if(number == 0){
            return;
        }
        System.out.println(name);
        printName(name,number-1);

    }

    private static void printNumber( int n) {
        if(n == 0){
            return;
        }

        printNumber( n-1);
        System.out.println("Number" + n);
    }

    public static int sumOfDigits(int n){
        if(n%10 == n){
            return n;
        }
        return n%10 + sumOfDigits(n/10);
    }

}
