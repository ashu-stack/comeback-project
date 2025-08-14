package Arrays;

public class SlidingWindowVariable {

    public static void main(String[] args) {
        //Sliding window of variable size
        int[] nums = {4,1,1,1,1,1,3,5};
        int condn = 5;
        int i=0, j=0, sum=0, maxSize=0;
        int n = nums.length;
        while(j<n)
        {
            sum += nums[j];
            if(sum < condn){
                j++;
            }
            else if (sum == condn)
            {
                maxSize = Math.max(j-i+1, maxSize);
                j++;
            }
             if (sum>condn){
                while(sum > condn){
                    sum = sum - nums[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println("Max window size: " +  maxSize);
    }
}
