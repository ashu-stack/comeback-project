package Maths;

public class MathsClass {
    public static void main(String[] args) {
        int n = 47;
        boolean prime = isPrime(n);
        System.out.println(prime);
    }

    private static boolean isPrime(int n) {
        if(n <= 1) return false;

        int c=2;
        while(c*c <= n){
            if(n%c == 0) return false;
            c++;
        }
        return true;
    }
}
