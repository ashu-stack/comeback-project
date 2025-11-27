package Arrays;

public class Stock {
    public static void main(String[] args) {
        int[] nums = {2,3,5,1,7,20,10};
        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] nums) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minPrice = Math.min(minPrice,nums[i]);
            maxProfit = Math.max(maxProfit, nums[i]-minPrice);
        }
        return maxProfit;
    }
}
