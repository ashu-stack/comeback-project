package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSumProblem {

    public static void main(String[] args) {
        int[] nums = {4,3,2,6,10,9};
        int target = 19;
        int[] ans = new int[2];
       // ans = twoSum(nums,target);
     //   System.out.println(Arrays.toString(ans));
        String s = "abcdefg";
       // s.replace('','');
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);

        String s1 = s.substring(2,5);
        List<Integer> l = new ArrayList<>();

    }

    private static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(nums, target-nums[i]);
            if(index > 0){
                ans[0] = nums[i];
                ans[1] = nums[index];
                break;
            }

        }
        return ans;
    }
}
