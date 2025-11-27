package Graphs;

import java.util.ArrayList;
import java.util.Stack;


public class KR {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0},{2,3},{3,4},{4,5},{5,6},{6,4},{6,7},{4,7}};;
        int n = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                dfsSt(i,vis,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            vis[i] = 0;
            for(Integer it : adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        int scc = 0;

        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfsc(node, vis,adjT);
            }
        }

        System.out.println(scc);

    }

    private static void dfsc(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for(Integer it : adjT.get(node)){
            if(vis[it] == 0){
                dfsc(it,vis,adjT);
            }
        }

    }

    private static void dfsSt(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfsSt(it,vis,adj,st);
            }
        }
        st.push(node);
    }

}
