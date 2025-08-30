package Strings;

public class LargestOdd {
    public static void main(String[] args) {
        String no  = "23553222";
        for (int i = 0; i < no.length(); i++) {
            int number = Integer.getInteger(no.substring(i,i+1));
            //System.out.println(number.s);
        }
    }
}
