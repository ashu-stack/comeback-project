package DynamicProgramming.knapsack;
import java.util.Arrays;
public class SubsetOfDifference {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        int sum = sumOfArray(arr);

        int s1 = (diff + sum)/2;
        int length = arr.length;
        int ways = subSetSum(arr, s1,length);
        System.out.println(ways);

    }

    private static int subSetSum(int[] arr, int w, int n) {
        int[][] t = new int[n+1][w+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if(i == 0) t[i][j] = 0;
                if(j == 0) t[i][j] = 1;
            }
        }
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < w+1 ; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }

    private static int sumOfArray(int[] arr) {

        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return sum;
    }
}
