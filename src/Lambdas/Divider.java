package Lambdas;

public class Divider {
    public int divide(Divide div, int a , int b){
        return div.divide(a,b);
    }

    public static void main(String[] args) {
        Divide divide = (int a, int b) -> {
            if(b == 0) return 0;
            return a/b;
        };
        Divider divider = new Divider();
        int ans = divider.divide(divide, 10, 0);
        System.out.println(ans);
    }
}
