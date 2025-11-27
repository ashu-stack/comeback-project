package Arrays;

public class Kadanes {
    public static void main(String[] args) {
        int[] arr = {2,-3,1,5,-1,-2,7,2};
        int max = maxSubArray(arr);
        System.out.println(max);
    }

    private static int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum < 0){
                sum=0;
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
