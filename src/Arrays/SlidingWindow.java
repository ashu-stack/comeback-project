package Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        //Fixed window size;
        int[] nums = {1,2,4,9,8,1,3,2,5};
        int k = 3;
        int n = nums.length;
        int i=0 , j=0;
        int sum=0, maxSum=Integer.MIN_VALUE;
        while(j<n){
            sum += nums[j];
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                maxSum = Math.max(sum,maxSum);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        System.out.println("Maximum sum = " + maxSum);



    }
}
