package Arrays;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {13,46,24,52,20,9};
        int n = arr.length;

        arr = selectionSort(arr,n);
        System.out.println(Arrays.toString(arr));



    }

    public static int[] selectionSort(int[] arr, int n){
        int mini;
        int temp;
        for (int i = 0; i < n-1; i++) {
            mini = i;
            for(int j = i; j<n; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;

        }
        return arr;
    }
}
