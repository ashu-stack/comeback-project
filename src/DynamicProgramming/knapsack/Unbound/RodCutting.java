package DynamicProgramming.knapsack.Unbound;

public class RodCutting {

    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int w = 8;

        int n = length.length;
        int maxProfit = unboundedMaxProfit(length, price, w,n);
        System.out.println(maxProfit);
    }

    private static int unboundedMaxProfit(int[] length, int[] price, int w, int n) {
        int[][] t = new int[n+1][w+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1 ; j++) {
                if(length[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}
