package CoreJava.CollectionFramework;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String,Image> cacheMap = new WeakHashMap<>();
        loadCache(cacheMap);
        System.out.println(cacheMap);
        System.gc();
        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){

        }
        System.out.println("After garbage collection: " + cacheMap);

    }

    private static void loadCache(WeakHashMap<String, Image> cacheMap) {
        String k1 = new String("img1");
        String k2 = new String("img2");
        cacheMap.put(k1, new Image("MyFace"));
        cacheMap.put(k2, new Image("My PP"));

    }
}
