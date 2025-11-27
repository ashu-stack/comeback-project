package Arrays;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,0,2,1,0,1,1,1,0,2,0,2,2,1,2,0,2,1,0,2,0,0,1,0,};
        System.out.println(Arrays.toString(nums));
        sort012(nums);
        System.out.println(Arrays.toString(nums));

    }


    private static void sort012(int[] nums) {
        int mid = 0,low=0;
        int high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                //swap(nums[low], nums[mid]);
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
               // swap(nums[mid], nums[high]);
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
