package Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {2,5,21,43,51,22,23};
        int toFind = 12;
        int index = linearSearch(nums,toFind);
        System.out.println(index);
    }

    private static int linearSearch(int[] nums,int toFind) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == toFind)
                return i;
        }
        return -1;
    }
}
