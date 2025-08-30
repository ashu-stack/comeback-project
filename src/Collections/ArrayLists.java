package Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();

        list.add(99);
        list.add(33);
        list.add(2,69);
        list.add(2,55);
        list.add(990);
        l.addAll(list);
        l.set(3,24);
        l.set(0,11);

//        for (int i = 0; i < l.size(); i++) {
//            System.out.println("Element : " + l.get(i));
//        }
//
//        for(Integer el : l){
//            System.out.println(el);
//        }
        System.out.println("Before multiplying: " + l);
        Iterator<Integer> it = l.iterator();
        int i=0;
        while(it.hasNext()){
            int temp = it.next() ;
            temp *= 10;
            l.set(i,temp);
            i++;
        }
        System.out.println("After multiplying: "+l);
    }
}
