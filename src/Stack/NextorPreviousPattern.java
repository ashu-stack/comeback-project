package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextorPreviousPattern {
    public static void main(String[] args) {
        int[] arr = {4,2,1,0,3,1};
        //ArrayList<Integer> nextGreater = nextGreaterRight(arr);
        //ArrayList<Integer> nextSmaller = nextSmaller(arr);
        ArrayList<Integer> prevGreater = previousGreater(arr);
        System.out.println(prevGreater);
    }

    private static ArrayList<Integer> previousGreater(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                list.add(-1);
            }
            else if(!st.isEmpty() && st.peek() > arr[i]){
                list.add(st.peek());
            }
            else if(!st.isEmpty() && st.peek() <= arr[i]){
                while(!st.isEmpty() && st.peek() <= arr[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    list.add(st.peek());
                }
                else{
                    list.add(-1);
                }
            }

            st.push(arr[i]);
        }
        //Collections.reverse(list);
        return list;
    }


    private static ArrayList<Integer> nextSmaller(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length-1;
        for(int i=n; i>=0; i--){
            if(st.isEmpty()){
                list.add(-1);
            }
            else if(!st.isEmpty() && st.peek() < arr[i]){
                list.add(st.peek());
            }
            else if(!st.isEmpty() && st.peek() >= arr[i]){
                while(!st.isEmpty() && st.peek() >= arr[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    list.add(st.peek());
                }
                else{
                    list.add(-1);
                }
            }
            st.push(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }

    private static ArrayList<Integer> nextGreaterRight(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length-1;
        for(int i=n; i>= 0; i--){
            if(st.isEmpty()){
                //st.push(-1);
                list.add(-1);
            }
            if(!st.isEmpty() && st.peek() > arr[i]){
                list.add(st.peek());
            }
            else if(!st.isEmpty() && st.peek() <= arr[i]){
                while(!st.isEmpty() && st.peek() <= arr[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    list.add(st.peek());
                }
                else{
                    list.add(-1);
                }
            }


            st.push(arr[i]);
        }
        Collections.reverse(list);
        return  list;
    }
}
