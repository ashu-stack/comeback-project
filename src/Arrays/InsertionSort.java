package Arrays;

import java.util.Arrays;


public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,2,1};
        arr = insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] insertionSort(int[] arr, int n) {

        for (int i = 1; i <= n-1 ; i++) {
            int j = i;
            while(j>0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }


        return arr;
    }
}
