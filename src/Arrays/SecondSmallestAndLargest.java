package Arrays;

public class SecondSmallestAndLargest {
    public static void main(String[] args) {
        int[] arr = {21,43,56,23,77,12,89,101};
        int length = arr.length;

        getElements(arr,length);

    }

    private static void getElements(int[] arr, int length) {

        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            small = Math.min(small,arr[i]);
            large = Math.max(large,arr[i]);
        }

        for (int i = 0; i < length; i++) {

            if(arr[i] < second_small && arr[i] != small){
                second_small = arr[i];
            }

            if(arr[i] > second_large && arr[i] != large){
                second_large = arr[i];
            }
        }

        System.out.println("Second largest number: "+ second_large + " Second smallest number: " + second_small);

    }


}
