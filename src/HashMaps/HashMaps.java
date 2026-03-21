package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        String st = "aaaabbcccdeefffff";  //     aabefffffebaa
        int maxPalindrome = maxPalindrome(st);
        System.out.println(maxPalindrome);
    }

    private static int maxPalindrome(String st) {
        char[] ch = st.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<ch.length; i++){
            map.put(ch[i], map.getOrDefault(ch[i],0)+1);
        }
        int length = 0;
        int maxOdd = 0;
        for(var entry : map.entrySet()){
            int n = entry.getValue();
            if(n%2 == 0){
                length += n;
            }
            else{
                maxOdd = Math.max(maxOdd, n);
            }
        }

        int ans = length + maxOdd;
        return ans;
    }
}
