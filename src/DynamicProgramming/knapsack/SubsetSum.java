package DynamicProgramming.knapsack;

public class SubsetSum {
    public static int[][] t = new int[101][101];

    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int w = 11;
        int n = arr.length;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1 ; j++) {
                t[i][j] = -1;
            }
        }
        boolean sub = subsetSum(arr,w,n);
        System.out.println(sub);
    }

    private static boolean subsetSum(int[] arr, int w, int n) {
        if(n==0){
            return false;
        }
        if(w == 0){
            return true;
        }
        if(t[n][w] != -1){
            return t[n][w]==1;
        }
        if(arr[n-1] <= w){
            boolean ans = subsetSum(arr,w-arr[n-1],n-1) || subsetSum(arr, w, n-1);
            if(ans){
                t[n][w] = 1;
            }
            else{
                t[n][w] = 0;
            }
            return ans;
        }
        else{
            boolean ans =  subsetSum(arr, w, n-1);
            if(ans){
                t[n][w] = 1;
            }
            else{
                t[n][w] = 0;
            }
            return ans;
        }
    }
}
