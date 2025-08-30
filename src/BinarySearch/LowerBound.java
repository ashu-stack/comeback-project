package BinarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7,8,8,11,11,11,12};
        int target = 8;
        int low=0, high=nums.length-1, ans=nums.length;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        System.out.println("Lower bound : " + ans);
    }
}
