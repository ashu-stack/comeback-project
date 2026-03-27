package CoreJava.CollectionFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.addAll(List.of("Bread", "Eggs", "Biscuits", "Cold drinks"));
//        for(String item : list){
//            if(item.equals("Biscuits")){
//                list.add("Milk");
//                System.out.println("milk added to the list during reading");
//            }
//        }

        Thread t1 = new Thread(()->{
            for(int i=0; i<10; i++){
                list.add("Maggi");
            }
        });

        Thread t2 = new Thread(()->{
            for(String item : list){
                if(!item.equals("Maggi")){
                    list.remove(item);
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){

        }finally {
            System.out.println(list);
        }

    }
}
