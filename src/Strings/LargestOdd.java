package Strings;

public class LargestOdd {
    public static void main(String[] args) {
        String no  = "23553222";

        String l = "4->6->7->8->";
        if(l.endsWith("->"));
        {
           // System.out.println(l.lastIndexOf("->"));
            l = l.substring(0,l.lastIndexOf("->")-1);
        }
        System.out.println(l);

    }
}
