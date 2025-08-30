package Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Sets {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> sortSet = new TreeSet<>();
        set.add(99);
        set.add(99);
        set.add(99);
        set.add(100);
        set.add(100);
        set.add(11);
        set.add(11);
        set.add(99);
        sortSet.add(100);
        sortSet.add(50);
        sortSet.add(400);
        sortSet.add(1);
        System.out.println(set);
        System.out.println(set.contains(99));
//        for(Integer i : set){
//            System.out.println(i);
//        }
        System.out.println(sortSet);

    }
}
