package Recursion;
import java.util.*;
public class PatternRecursion {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        bSort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));

    }
    public static void printPattern(int r, int c){
        if(r == 0){
            return;
        }
        if(c < r){
            System.out.print("*");
            printPattern(r , c+1);
        }
        else{
            System.out.println();
            printPattern(r-1, 0);
        }
    }

    public static void bSort(int[] arr, int r, int c){
        if(r == 0){
            return;
        }
        if(c<r){
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bSort(arr,r,c+1);
        }
        else{
            bSort(arr, r-1,0);
        }
    }
}
