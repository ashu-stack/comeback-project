package Recursion;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
////        subset("", "abc");
//        System.out.println(subset2("", "abc"));
       // permutations("", "abc");
        System.out.println(permutationList("", "abc"));
    }

    private static void subset(String p, String up) {

        if(up.isEmpty()){
            System.out.print(p + ", ");
            return;
        }
        char ch = up.charAt(0);
        subset(p , up.substring(1));
        subset(p + ch, up.substring(1));
    }

    private static ArrayList<String> subset2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subset2(p + ch, up.substring(1));
        ArrayList<String> right = subset2(p, up.substring(1));
        left.addAll(right);
        return left;

    }

    public static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }

    public static ArrayList<String> permutationList(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationList( f+ch+s, up.substring(1)));
        }
        return ans;

    }
}
