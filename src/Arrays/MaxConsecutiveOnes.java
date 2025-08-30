package Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        int ans = findMaxConsecutiveOnes(arr);
        System.out.println(ans);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count += 1;
            }
            else{
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);

        //return 0;
    }
}
