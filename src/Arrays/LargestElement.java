package Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {8,6,2,11,67,43,100};
        int largest = largestElement(arr, arr.length);
        System.out.println(largest);
    }

    private static int largestElement(int[] arr, int length) {

        int largest = arr[0];
        for (int i = 1; i <= length-1; i++) {
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;

    }
}
