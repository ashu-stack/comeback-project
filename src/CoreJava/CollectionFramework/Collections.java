package CoreJava.CollectionFramework;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.addAll(List.of("Bread", "Eggs", "Biscuits", "Cold drinks"));
        for(String item : list){
            if(item.equals("Biscuits")){
                list.add("Milk");
                System.out.println("milk added to the list during reading");
            }
        }
        System.out.println(list);
    }
}
