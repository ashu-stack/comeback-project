package Recursion;

public class StringsRecursion {
    public static void main(String[] args) {
        String s = "aaaaabbapplebbbcccxx";
       String str  = skipApple(s);
        System.out.println(str);
    }

    private static void skip(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        }else{
            skip(p + ch, up.substring(1));
        }
    }

    private static String skip2(String up){
        //String ans = "";
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip2(up.substring(1));
        }else{
            return  ch + skip2(up.substring(1));
        }
    }

    private static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
}
