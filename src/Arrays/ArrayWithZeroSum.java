package Arrays;

public class ArrayWithZeroSum {
    public static void main(String[] args) {
        int[] nums =  {9, -3, 3, -1, 6, -5};
        int n = nums.length;
        int target = 0;
        int i=0, j=0;
        int sum=0, maxSize=Integer.MIN_VALUE;
        while(j<n){
            sum += nums[j];
            if(sum < target){
                j++;
            }
            if(sum == target){
                maxSize = Math.max(j-i+1, maxSize);
                j++;
            }
            else if (sum > target){
                while(sum > target){
                    sum = sum-nums[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println("Maximum size: " + maxSize);
    }
}
