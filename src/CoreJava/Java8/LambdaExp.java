package CoreJava.Java8;

public class LambdaExp {
    public static void main(String[] args) {
        MathOperation sum = (a,b) -> a+b;
        MathOperation difference = (a,b) -> Math.abs(a-b);
        MathOperation product = (a,b) -> a*b;

        System.out.println("Sum : "+sum.operate(5,5));
        System.out.println("Product: " + product.operate(5,5));

    }

    public interface MathOperation{
        int operate(int a, int b);
    }
}
