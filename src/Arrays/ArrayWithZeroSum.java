package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayWithZeroSum {
    public static void main(String[] args) {

        int a = 10,b=20;
        int diff = Math.abs(a-b);
        System.out.println(diff);
        ArrayList<Integer> l = new ArrayList<>()  ;
        l.add(3);
        l.add(5);
        l.add(4);
        l.add(3);
        l.add(1);
        l.add(9);
        //int[] a = {2,3,5,5,6,7};
        //ArrayList<Integer> list = new ArrayList<>(a);

        l.contains(2);
        System.out.println(l.get(2));
        System.out.println(l.get(l.size()-1));
    }
}
