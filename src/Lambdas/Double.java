package Lambdas;

public class Double {
    public int operate(Doubling doubling, int a){
        return doubling.operate(a);
    }

    public static void main(String[] args) {
        Doubling doubling = (int a) -> a*2;
        Doubling doubling1 = (int a) -> a*a;
        Double aDouble = new Double();
        int ans = aDouble.operate(doubling1,10);
        System.out.println("Double of the number is : " + ans);
    }
}
