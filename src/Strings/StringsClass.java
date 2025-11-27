package Strings;

public class StringsClass {
    public static void main(String[] args) {

        String s = "(()())(())";
        StringBuilder builder = new StringBuilder(s);


        for (int i=0; i<s.length()-2; i++){
            if(s.charAt(i) == '(' && s.charAt(i+1) == '('){
                builder.deleteCharAt(i+1);
            }
            else if (s.charAt(i) == ')' && s.charAt(i+1) == ')'){
                builder.deleteCharAt(i+1);
            }
        }
        System.out.println(builder);
        //System.out.println(builder.append('d'));
        //System.out.println(builder.indexOf("a") + "  " + builder.lastIndexOf("a"));






//        //System.out.println(name);
//        System.out.println(name.compareToIgnoreCase(name2));
//        System.out.println(name.charAt(21));
    }
}
