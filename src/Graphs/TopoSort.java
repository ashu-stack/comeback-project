package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        int edges[][] = {{5,0}, {4,0},{4,1}, {3,1}, {2,3}, {5,2} };
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }

        int[] vis = new int[v];
        for(int i=0; i< vis.length; i++){
            vis[i] = 0;
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< vis.length; i++){
            if(vis[i] == 0){
                dfsTopo(i,st,vis,adj);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            int it = st.pop();
            list.add(it);
        }
        System.out.println(list);

    }

    private static void dfsTopo(int node, Stack<Integer> st, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                vis[it] = 1;
                dfsTopo(it,st,vis,adj);
            }
        }
        st.push(node);
    }
}
