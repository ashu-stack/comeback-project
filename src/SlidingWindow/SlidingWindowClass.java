package SlidingWindow;

public class SlidingWindowClass {
    public static void main(String[] args) {
        int[] arr = {3,5,12,66,2,21,11,55,1,1,1};
        int size = 3;

        //max sum of a subarray of size k;
       // int maxSum = findMaxSum(arr, size);

        //min sum of a subarray of size k
       // int minSum = findMinSum(arr,size);

        //min average of subarray of size k
       // float avg = findMinAvg(arr,size);

        //max average of subarray of size k
        float avg = findMaxAvg(arr, size);
        System.out.println(avg);
    }

    private static float findMaxAvg(int[] arr, int size) {
        float maxAvg = Float.MIN_VALUE;
        int windowSum = 0;
        int n = arr.length;
        for(int i=0; i<size; i++){
            windowSum += arr[i];
        }
        maxAvg = (float) windowSum/size;
        for(int i=size; i<n; i++){
            windowSum += arr[i] - arr[i-size];
            float avg = (float) windowSum/size;
            maxAvg = Math.max(maxAvg,avg);
        }
        return maxAvg;
    }


    private static float findMinAvg(int[] arr, int size) {
       // float minAvg = Float.MAX_VALUE;
        int n= arr.length;
        int windowSum = 0;
        float winAvg = 0;
        for(int i=0; i<size; i++){
            windowSum += arr[i];

        }
        winAvg = (float) windowSum /size;
        for(int i=size; i<n; i++){
            windowSum += arr[i] - arr[i-size];
            float avg = (float) windowSum/size;
            winAvg = Math.min(winAvg,avg);
        }

        return winAvg;
    }

    private static int findMinSum(int[] arr, int size) {
        int minSum = Integer.MAX_VALUE;
        int n = arr.length;
        int windowSum=0;
        for(int i=0; i<size; i++){
            windowSum += arr[i];
        }
        minSum = windowSum;

        for(int i=size; i<n; i++){
            windowSum += arr[i] - arr[i-size];
            minSum = Math.min(minSum,windowSum);
        }

        return minSum;

    }



    private static int findMaxSum(int[] arr, int size) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        int windowSum=0;
        for(int i=0; i<size; i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for(int i=size; i<n; i++){
            windowSum += arr[i] - arr[i-size];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
