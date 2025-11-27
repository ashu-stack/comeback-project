package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DirectedAcyclic {
   static class Pairs{
        int first;
        int second;

        public Pairs(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{6,4,2},{4,0,3},{0,1,2},{1,3,1},
                {6,5,3},{5,4,1},{4,2,1},{2,3,3}};
        int n = 7;
        ArrayList<ArrayList<Pairs>> adj = new ArrayList<>();
        for(int i=0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pairs(v,wt));
        }
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                topoSort(i,adj,vis,st);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        int src = st.peek();
        dist[src] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for(int i=0; i<adj.get(node).size(); i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(dist[node] + wt < dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    private static void topoSort(int node, ArrayList<ArrayList<Pairs>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for(int i=0; i<adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
}
