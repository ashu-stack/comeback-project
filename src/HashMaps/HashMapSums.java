package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class HashMapSums {
    public static void main(String[] args) {
        String st = "aabcbcxeeeff";
        char[] ch = st.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<ch.length; i++){
            map.put(ch[i], map.getOrDefault(ch[i], 0)+1);
        }

        for(int i=0; i<ch.length; i++){
            if(map.get(ch[i]) == 1) System.out.println(ch[i]);
        }

    }
}
