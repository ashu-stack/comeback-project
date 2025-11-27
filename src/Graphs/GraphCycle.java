package Graphs;

import java.util.ArrayList;

public class GraphCycle {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,1}};
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }
        int[] vis = new int[n+1];
        int[] pathVis = new int[n+1];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = 0;
            pathVis[i] = 0;
        }
        boolean ans = false;
        for(int i = 1; i< vis.length; i++){
            if(vis[i] == 0){
                if(checkCycleDfs(i, adj, vis, pathVis) ){
                    ans = true;
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean checkCycleDfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(checkCycleDfs(it,adj,vis,pathVis) ){
                    return true;
                }

            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;

    }
}
