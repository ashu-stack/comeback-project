package CoreJava.CollectionFramework;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {

    public static void main(String[] args) {
//        Map<Students, String> map = new EnumMap<Students,String>(Students.class);
//        map.put(Students.nandu,"Nandini");
//        map.put(Students.sohu, "Soham");
//        map.put(Students.ashu,"Ashutosh");
//        System.out.println(map);

        Map<Integer, String> maps = new ConcurrentHashMap<>();
//        maps.put(1, "DSA");
//        maps.put(2, "spring boot");

        Thread thread = new Thread(()->{
            for(int i=0; i<1000; i++){
                maps.put(i, "Student"+i);
            }
        });
        Thread thread1 = new Thread(()->{
            for(int i=1000; i<=2000; i++){
                maps.put(i,"Student"+i);
            }
        });

        thread.start();
        thread1.start();

        try{
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(maps.size());


    }

    public enum Students{
        ashu, sohu, nandu
    }
}
