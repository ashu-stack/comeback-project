package SlidingWindow;

public class VariableWindowClass {
    public static void main(String[] args) {
        int[] arr = {3,4,5,8,7,22,2,14,9};
        int target = 12;
        int smallest = findSmallestSubArray(arr, target);
        System.out.println(smallest);

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
