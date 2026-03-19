package SlidingWindow;

public class SlidingWindowClass {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1};
        int size = 6;

        //max sum of a subarray of size k;
       // int maxSum = findMaxSum(arr, size);

        //min sum of a subarray of size k
       // int minSum = findMinSum(arr,size);

        //min average of subarray of size k
       // float avg = findMinAvg(arr,size);

        //max average of subarray of size k
        //float avg = findMaxAvg(arr, size);
        int maxOneCount = findMaxOneCount(arr,size);
        System.out.println(maxOneCount);
    }

    private static int findMaxOneCount(int[] arr, int size) {
        int maxOneCount=0;
        int left=0, right=0;
        int oneCount=0;
        while(right < size){
            if(arr[right] == 1) oneCount++;
            right++;
        }

        maxOneCount = oneCount;
        for(right = size; right<arr.length; right++){
            if(arr[right] == 1) oneCount++;
            if(arr[left] == 1) oneCount--;
            left++;

            maxOneCount = Math.max(maxOneCount,oneCount);
        }
        return maxOneCount;

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
