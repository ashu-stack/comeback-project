package Collections;

import java.util.Iterator;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(21);
        st.push(34);
        st.push(91);
        st.push(36);
        st.push(21);
        st.push(34);

        System.out.println(st.size());
//        while(st.size()>=0){
//            System.out.println(st.peek());
//            st.pop();
//        }
        Iterator<Integer> it = st.iterator();
        while(it.hasNext()){
            System.out.println(st.peek());
            st.pop();
        }



    }
}
