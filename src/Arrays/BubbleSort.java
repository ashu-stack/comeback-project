package Arrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {13,24,46,20,52,9};
        int n = arr.length;

        arr = bubbleSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] bubbleSort(int[] arr, int n) {

        for(int i = n-1; i >= 0; i--){

            for (int j = 0; j <= i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
