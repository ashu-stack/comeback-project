package SlidingWindow;

public class VariableWindowClass {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,6,14,2};
        int target = 22;
       // int smallest = findSmallestSubArray(arr, target);
        int largest = findLargestSubArray(arr,target);

        //max subarray with sum at most k
        int atMostK = atMostK(arr,target);
        System.out.println(atMostK);

    }

    private static int atMostK(int[] arr, int target) {
        int res= Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        for(int right=0; right<arr.length; right++){
            sum += arr[right];
            if(sum <= target){
                res = Math.max(res, right-left+1);
            }
            else{
                while(sum > target){
                    sum -= arr[left];
                    left++;
                }
                res = Math.max(res, right-left+1);
            }
        }
        return res;
    }

    private static int findLargestSubArray(int[] arr, int target) {
        int left=0;
        int maxLength = Integer.MIN_VALUE;
        int sum=0;
        for(int right=0; right<arr.length; right++){
            sum += arr[right];
            if(sum == target){
                maxLength = Math.max(maxLength, right-left+1);
            }
            if(sum > target){
                while (sum > target){
                    sum -= arr[left];
                    left++;
                }
                if(sum == target){
                    maxLength = Math.max(maxLength, right-left+1);
                }
            }
        }
        return maxLength;
    }

    private static int findSmallestSubArray(int[] arr, int target) {
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right=0; right<arr.length; right++){
            sum += arr[right];
            if(sum == target){
                minLength = Math.min(minLength, right-left+1);
            }
            if(sum > target) {
                while (sum > target) {
                    sum -= arr[left];
                    left++;
                }
                if(sum == target){
                    minLength = Math.min(minLength, right-left+1);
                }
            }
        }
        return minLength;
    }
}
