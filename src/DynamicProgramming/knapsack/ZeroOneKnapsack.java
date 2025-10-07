package DynamicProgramming.knapsack;

import java.util.Arrays;

public class ZeroOneKnapsack {
    static int[][] t = new int[5][8];
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int n = wt.length;
        int W = 7;
        int ans = knapsackRecursive(wt,val,W,n);
        System.out.println(ans);


        for(int i=0; i<n+1; i++){
            Arrays.fill(t[i],-1);
        }
        int ansMemo = knapsackMemo(wt,val,W,n);
        System.out.println(ansMemo + "   " + ans);



    }

    private static int knapsackMemo(int[] wt, int[] val, int w, int n) {
        if(n == 0 || w == 0){
            return 0;
        }

        if(t[n][w] != -1){
            return t[n][w];
        }

        if(wt[n-1] <= w){
            t[n][w] = Math.max((val[n-1] + knapsackRecursive(wt,val,w-wt[n-1], n-1)),
                    (knapsackRecursive(wt,val,w,n-1)));

            return t[n][w];
        }
        else{
            t[n][w] = knapsackRecursive(wt,val,w,n-1);
            return t[n][w];
        }
    }

    private static int knapsackRecursive(int[] wt, int[] val, int w, int n) {
        if(n == 0 || w == 0){
            return 0;
        }

        if(wt[n-1] <= w){
            return Math.max((val[n-1] + knapsackRecursive(wt,val,w-wt[n-1],n-1)),
                    knapsackRecursive(wt,val,w,n-1));
        }
        else{
           return knapsackRecursive(wt,val,w,n-1);
        }

    }
}
