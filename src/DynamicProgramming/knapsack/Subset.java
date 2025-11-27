package DynamicProgramming.knapsack;

public class Subset {

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        //int sum = 11;

        //boolean ans = subsetExists(arr, sum, arr.length);
        //System.out.println(ans);
//
//        int setCount = subSetCount(arr,sum,arr.length);
//        System.out.println(setCount);

        boolean equalSumPart = equalSumPartition(arr,arr.length);
        System.out.println(equalSumPart);
    }

    private static boolean equalSumPartition(int[] arr, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        if(sum %2 != 0){
            return false;
        }
        else{
            return subsetExists(arr, sum/2, arr.length);
        }
    }


    private static int subSetCount(int[] arr, int sum, int n) {

        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i == 0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    private static boolean subsetExists(int[] arr, int sum, int n) {
            boolean[][] t = new boolean[n+1][sum+1];
            for(int i=0; i<n+1; i++){
                for(int j=0; j<sum+1;j++){
                    if(i==0) t[i][j] = false;
                    if(j==0) t[i][j] = true;
                }
            }
        for(int i=1; i<n+1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];

    }
}
