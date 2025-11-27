package Lambdas;

public class Operator {
    public int operate(Operate operate, int a , int b){
        return operate.perform(a,b);
    }

    public static void main(String[] args) {
        Operate operate = (int a, int b) -> a / b;
        Operator op = new Operator();
        int ans = op.operate(operate,4, 7);
        System.out.println("Answer : " + ans);
    }
}
