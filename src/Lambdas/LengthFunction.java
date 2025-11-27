package Lambdas;

public class LengthFunction {
    public int findLength(MyLength myLength , String s){
        return myLength.length(s);
    }

    public static void main(String[] args) {
        MyLength m = (String s) -> s.length();
        LengthFunction function = new LengthFunction();
        int ans = function.findLength(m, "Ashutosh Shukla");
        System.out.println("Length of the string is : " + ans);
    }
}

 interface MyLength{
    int length(String s);
}