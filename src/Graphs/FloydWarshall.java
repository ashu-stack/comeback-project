package Graphs;

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        int[][] cost = {{0,2,(int)1e9,(int)1e9},
                {1,0,3,(int)1e9},
                {(int)1e9, (int)1e9, 0, (int)1e9},
                {3,5,4,0}};
        int n = 4;

        for(int k=0; k<n;k++ ){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        System.out.println(cost[3][2]);
    }

}
